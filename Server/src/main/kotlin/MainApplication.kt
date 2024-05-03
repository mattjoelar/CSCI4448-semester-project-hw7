package org.example

import com.ooadproject.projectmonDB.DatabaseApplication
import com.ooadproject.projectmonDB.dao.PartyDao
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication(scanBasePackages = ["com.ooadproject.projectmonDB"])
open class MainApplication

fun main() {
    val context = SpringApplication.run(DatabaseApplication::class.java)
    val partyDao = context.getBean(PartyDao::class.java)


    val player1 = Player()
    val player2 = Player()


    val choice1 = PartyChoice(player1, partyDao)
    val choice2 = PartyChoice(player2, partyDao)

    println("Choose Parties")
    choice1.playerChoice("Mike")
    choice2.playerChoice("John")


    val battle = Battle(player1, player2)

    println("Starting battle!\n======")
    battle.runTurn(ChoiceFactory.createUseMoveChoice(0), ChoiceFactory.createUseMoveChoice(0))
    println("=====\nEnding battle!")
}