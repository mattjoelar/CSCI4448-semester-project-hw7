package org.example

import com.ooadproject.projectmonDB.dao.PartyDao
import com.ooadproject.projectmonDB.model.Party
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class PartyChoice(private val player1 : Player, private val partyDao: PartyDao) {

//    @Autowired
//    lateinit var partyDao: PartyDao

//    private fun getPlayer(idx : Int) : Player {
//        return if(idx == 0) player1 else player2
//    }

    private fun invalidInput(playerIdx: Int) {
        println("Invalid input received!")
    }

    fun playerChoice() {

        println("Choose a Party")
        printParties()
        if (getParties() == null) {
            println("There is no party in the list")
            return
        } else {
            //get player choice
            val choice = 0
            if (choice <= getParties()!!.size && choice >= 0) {
                this.player1.setPartyIDx(choice)
            }
            this.player1.setPartyIDx(choice)
            return
        }
    }

    private fun getParties() : MutableList<Party>? {
        return partyDao.getAllParties()
    }

    private fun printParties() {
        partyDao.printAllParties() }
}



