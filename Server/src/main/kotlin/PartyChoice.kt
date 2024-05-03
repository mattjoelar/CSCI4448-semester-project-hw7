package org.example

import Projectmon.ProjectmonIdentifier
import com.ooadproject.projectmonDB.dao.PartyDao
import com.ooadproject.projectmonDB.model.Creature
import com.ooadproject.projectmonDB.model.Party
import org.example.Projectmon.ProjectmonFactory
import org.example.Projectmon.ProjectmonFactory.Companion.createFromDb
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class PartyChoice(private val player1 : Player, private val partyDao: PartyDao) {


    private fun invalidInput(playerIdx: Int) {
        println("Invalid input received!")
    }

    fun playerChoice(name: String) {

        println("Choose a Party")
        printParties()
        println("Searching for: $name")
        val parties = getParties()
        if (parties!!.isEmpty()) {
            println("There is no party in the list")
            println("Creating new random party")
            for (i in 1..5){
                player1.projectmons[i] = ProjectmonFactory.generateNewProjectmon( getRandomProjectmonIdentifier(), 1)
            }

            player1.partyName = name
//            saveParty(player1)
            return

        } else if(parties.any { it.name == name }){
            println("Good Choice!!")

            val party = getPartyByName(name)
            val creatures = getCreatures(party)

            player1.partyName = name
            for(i in 0..getCreatures(party).size){
                player1.projectmons[i] = createFromDb(creatures[i])
            }

            return
        }
    }


    private fun getRandomProjectmonIdentifier(): ProjectmonIdentifier {
        val id = Random.nextInt(1,4)
        return ProjectmonIdentifier.getIdentifier(id)
    }

    private fun getParties() : MutableList<Party>? {
        return partyDao.getAllParties()
    }

    private fun getPartyByName(name: String): Party? {
        return partyDao.getPartyByName(name)
    }

    private fun getCreatures(party: Party?): List<Creature>{
        return party!!.creatures
    }

    private fun printParties() {
        partyDao.printAllParties() }
}