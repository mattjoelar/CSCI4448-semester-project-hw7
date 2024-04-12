package org.example

class Battle(val player1 : Player, val player2 : Player) {

    fun runBattle() {
        var player1PjmnIdx: Int = 0
        var player2PjmnIdx: Int = 0
        while (true) {
            val player1Message : NetworkMessage = ChoiceFactory.createUseMoveChoice(0)
            val player2Message : NetworkMessage = ChoiceFactory.createUseMoveChoice(0)

            val player1Choice = player1Message.asMap()
            when(player1Choice["choice"]) {
                "useMove" -> {
                    println("Using a move!!!")
                }
                else -> {
                    println("Unrecognized value!")
                }
            }
            break
        }
        println("Wooooo epic battle! Are you enjoying the battle so far!?!?!?!\n")

        val stringInput : String = readln()

        println("$stringInput? Splendid! (This is the end of the program)\n")
    }
}