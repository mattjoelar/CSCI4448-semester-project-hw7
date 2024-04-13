package org.example

import org.example.Creatures.ProjectmonName
import org.example.Projectmon.ProjectmonFactory

fun main() {
    val player1 = Player()
    player1.projectmons[0] = ProjectmonFactory.generateNewCreature(ProjectmonName.PIKAMAN, 10)
    val player2 = Player()
    player2.projectmons[0] = ProjectmonFactory.generateNewCreature(ProjectmonName.PIKAMAN, 10)

    val battle = Battle(player1, player2)

    println("Starting \"battle\"!\n")
    battle.runTurn(ChoiceFactory.createUseMoveChoice(0), ChoiceFactory.createUseMoveChoice(0))
    println("Ending \"battle\"!\n")
}