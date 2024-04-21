package org.example

import org.example.Creatures.Entries
import org.example.Creatures.Projectmon

class Battle(private val player1 : Player, private val player2 : Player) {
    private fun getPlayer(idx : Int) : Player {
        return if(idx == 0) player1 else player2
    }

    private fun invalidInput(playerIdx : Int) {
        println("Invalid input received!")
    }

    fun runTurn(player1Message : NetworkMessage, player2Message : NetworkMessage) {
        fun getMessage(idx : Int) : NetworkMessage {
            return if(idx == 0) player1Message else player2Message
        }

        val turnOrder : IntArray = if(player1.getActiveProjectmon().speed >= player1.getActiveProjectmon().speed) intArrayOf(0, 1) else intArrayOf(1, 0)
        for(turn in turnOrder) {
            val player = getPlayer(turn)
            val otherPlayer = getPlayer(1-turn)
            val playerChoice = getMessage(turn).asMap()
            var success : Boolean = false

            //println("{$playerChoice")
            when(playerChoice["choice"]) {
                "useMove" -> {
                    playerChoice["moveIdx"]?.let {
                        data -> data.toString().toIntOrNull()?.let {
                            idx -> if(idx in 0..3 && player.getActiveProjectmon().getPpOfMove(idx) > 0) {
                                println("It's player ${turn + 1}'s turn!")
                                val originalHealth = otherPlayer.getActiveProjectmon().health
                                player.getActiveProjectmon().useMoveAgainst(idx, otherPlayer.getActiveProjectmon())
                                println("${Entries.lookupProjectmon(player.getActiveProjectmon().name).name} used ${Entries.lookupMove(player.getActiveProjectmon().getMove(idx)).name} and dealt ${originalHealth - otherPlayer.getActiveProjectmon().health} damage, leaving its opponent at ${otherPlayer.getActiveProjectmon().health}!")
                                success = true
                            } else {
                                println("Error: ${player}'s useMove request used index $idx which has pp of ${player.getActiveProjectmon().getPpOfMove(idx)}.")

                            }
                        }
                    }
                }

                "switchPjmn" -> {
                    playerChoice["swapToIdx"]?.let {
                        data -> data.toString().toIntOrNull()?.let {
                            idx -> if(idx in 0..5 && !player.projectmons[idx].isDead()) {
                                println("Switching projectmon!!!")
                                player.selectedProjectmonIdx = idx
                                success = true
                            } else {
                                println("Error: Something was wrong with player ${player}'s switchPjmn request.")
                            }
                        }
                    }
                }

                "forfeit" -> {
                    println("Player $turn forfeits! All of their projectmons shall now be executed.")
                    for(projectmon in player.projectmons) {
                        projectmon.health = 0f
                    }
                    return
                }

                else -> {
                    println("Unrecognized value!")
                }
            }

            if(!success) {
                invalidInput(turn)
            }
        }
    }
}