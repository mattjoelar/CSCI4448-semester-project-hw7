package org.example

fun main() {
    val player1 = Player()
    val player2 = Player()
    val battle = Battle(player1, player2)
    battle.runBattle()
}