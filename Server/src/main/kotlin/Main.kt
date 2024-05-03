package org.example

//import com.ooadproject.projectmonDB.DatabaseApplication
import com.ooadproject.projectmonDB.dao.PartyDao
import org.example.Creatures.ProjectmonIdentifier
import org.example.Projectmon.ProjectmonFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication(scanBasePackages = ["com.ooadproject.projectmonDB"])
//@EnableAutoConfiguration -- automatically added
@EnableTransactionManagement
open class Application

fun main(args: Array<String>) {
    val context = SpringApplication.run(Application::class.java)
    val partyDao = context.getBean(PartyDao::class.java)



    val player1 = Player()
//    player1.projectmons[0] = ProjectmonFactory.generateNewProjectmon(ProjectmonIdentifier.PIKAMAN, 10)
    val player2 = Player()
//    player2.projectmons[0] = ProjectmonFactory.generateNewProjectmon(ProjectmonIdentifier.PIKAMAN, 10)

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