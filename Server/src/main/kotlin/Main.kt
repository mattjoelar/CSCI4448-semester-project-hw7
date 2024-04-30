package org.example

import org.example.Creatures.ProjectmonIdentifier
import org.example.Projectmon.ProjectmonFactory
import java.awt.Choice

fun main() {
    val player1 = Player()
    player1.projectmons[0] = ProjectmonFactory.generateNewProjectmon(ProjectmonIdentifier.PIKAMAN, 10)
    val player2 = Player()
    player2.projectmons[0] = ProjectmonFactory.generateNewProjectmon(ProjectmonIdentifier.PIKAMAN, 10)

    val choice1 = ChooseParty(player1)
    val choice2 = ChooseParty(player2)

    println("Choose Parties")
    choice1.playerChoice()
    choice2.playerChoice()

    val battle = Battle(player1, player2)

    println("Starting battle!\n======")
    battle.runTurn(ChoiceFactory.createUseMoveChoice(0), ChoiceFactory.createUseMoveChoice(0))
    println("=====\nEnding battle!")
}