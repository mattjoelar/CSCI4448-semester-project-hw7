package org.example

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
            val playerChoice = getMessage(turn).asMap()
            var success : Boolean = false

            println("{$playerChoice")
            when(playerChoice["choice"]) {
                "useMove" -> {
                    println("I wanna use a move")
                    playerChoice["moveIdx"]?.let {
                        data -> data.toString().toIntOrNull()?.let {
                            idx -> if(idx in 0..3 && player.getActiveProjectmon().getPpOfMove(idx) > 0) {
                                println("Using move!!!")
                                // Use move here
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

                else -> {
                    println("Unrecognized value!")
                }
            }

            if(!success) {
                invalidInput(turn)
            }
        }
        //println("Wooooo epic battle! Are you enjoying the battle so far!?!?!?!\n")
        //val stringInput : String = readln()
        //("$stringInput? Splendid! (This is the end of the program)\n")
    }
}