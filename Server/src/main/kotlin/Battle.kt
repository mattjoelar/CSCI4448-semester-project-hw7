package org.example

import Projectmon.Entries
import Projectmon.ProjectmonData

class Battle(private val player1 : Player, private val player2 : Player) {

    // This should be marked as private but don't want to push any bad changes
    public var arena : Arena = Arena()

    // Marking as public for tests
    public fun getPlayer(idx : Int) : Player {
        return if(idx == 0) player1 else player2
    }

    fun useMove(player1: Player, player2: Player, moveIdx: Int) : ChoiceResult {
        var ret = ChoiceResult(false, arrayOf())

        if(moveIdx in 0..3 && player1.getActiveProjectmon().getPpOfMove(moveIdx) > 0) {
            val originalHealth = player2.getActiveProjectmon().health
            ret.messages += player1.getActiveProjectmon().useMoveAgainst(moveIdx, player2.getActiveProjectmon(), arena)
            //println("${Entries.lookupProjectmon(player1.getActiveProjectmon().currentData.identifier).name} used ${Entries.lookupMove(player.getActiveProjectmon().getMove(idx)).name} and dealt ${originalHealth - otherPlayer.getActiveProjectmon().health} damage, leaving its opponent at ${otherPlayer.getActiveProjectmon().health}!")
            ret.wasSuccessful = true
        } else {
            println("Error: ${player1}'s useMove request used index $moveIdx which has pp of ${player1.getActiveProjectmon().getPpOfMove(moveIdx)}.")
            ret.wasSuccessful = false
        }

        return ret
    }

   fun switchProjectmon(player : Player, idx : Int) : ChoiceResult {
        var ret = ChoiceResult(false, arrayOf())

        if(idx in 0..5 && !player.projectmons[idx].isDead()) {
            ret.messages += "Come back, ${player.getActiveProjectmon().getName()}!"
            player.selectedProjectmonIdx = idx
            ret.wasSuccessful = true
            ret.messages += "Go, ${player.getActiveProjectmon().getName()}!"
        } else {
            println("Error: Something was wrong with player ${player}'s switchPjmn request.")
            ret.wasSuccessful = false
        }

        return ret
    }

    fun playerForfeit(player : Player) : ChoiceResult {
        for(projectmon in player.projectmons) {
            projectmon.health = 0f
        }
        return ChoiceResult(true, arrayOf("Player gave up!"))
    }


    // Run this as soon as both players send in a JSON choice
    fun runTurn(player1Message : NetworkMessage, player2Message : NetworkMessage) : NetworkMessage {
        fun getMessage(idx : Int) : NetworkMessage {
            return if(idx == 0) player1Message else player2Message
        }

        var cumulativeMessages : Array<String> = arrayOf()

        val turnOrder : IntArray = if(player1.getActiveProjectmon().currentData.speed >= player1.getActiveProjectmon().currentData.speed) intArrayOf(0, 1) else intArrayOf(1, 0)
        for(turn in turnOrder) {
            val player = getPlayer(turn)
            val otherPlayer = getPlayer(1-turn)
            val playerChoice = getMessage(turn).asMap()

            //println("{$playerChoice")
            when(playerChoice["choice"]) {
                "useMove" -> {
                    playerChoice["moveIdx"]?.let {
                        data -> data.toString().toIntOrNull()?.let {
                            idx ->
                            {
                                val result : ChoiceResult = useMove(player, otherPlayer, idx)
                                if(!result.wasSuccessful) {
                                    throw Exception("Invalid choice command! Move idx ${idx}")
                                }
                                cumulativeMessages += result.messages
                            }
                        }
                    }
                }

                "switchPjmn" -> {
                    playerChoice["swapToIdx"]?.let {
                        data -> data.toString().toIntOrNull()?.let {
                            idx -> {
                                val result : ChoiceResult = switchProjectmon(player, idx)
                                if(!result.wasSuccessful) {
                                    throw Exception("Invalid switch command! Switch idx ${idx}")
                                }
                                cumulativeMessages += result.messages
                            }
                        }
                    }
                }

                "forfeit" -> {
                    println("Player $turn forfeits! All of their projectmons shall now be executed.")
                    cumulativeMessages += playerForfeit(player).messages
                }

                else -> {
                    println("Unrecognized value!")
                }
            }
        }

        // @ Matt - this is what you have to fill out
        // Messages to print to the screen are in local variable "cumulativeMessages"
        return NetworkMessage("JSON representing game state goes here! Messages to print are: ${cumulativeMessages}")
    }
}