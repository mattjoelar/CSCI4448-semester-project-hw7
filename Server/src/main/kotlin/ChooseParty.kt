package org.example

package org.springframework.beans.factory

import com.ooadproject.projectmonDB.dao.PartyDao
import com.ooadproject.projectmonDB.model.Party
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController
class ChooseParty(private val player1 : Player) {

    @Autowired
    private var partyDao: PartyDao? = null

//    private fun getPlayer(idx : Int) : Player {
//        return if(idx == 0) player1 else player2
//    }

    private fun invalidInput(playerIdx : Int) {
        println("Invalid input received!")
    }

    private fun getParties() : MutableList<Party>? {
        return partyDao?.allParties
    }

    private fun printParties(){
        println(partyDao?.allParties)

    }

    fun playerChoice() {

        println("Choose a Party")
        printParties()
        if(getParties() == null) {
            println("There is no party in the list")
            return
        }
        //get player choice
        val choice = 0
        if(choice <= getParties()!!.count() && choice >= 0) {
            this.player1.setPartyIDx(choice)
        }
        this.player1.setPartyIDx(choice)
        return
    }
}
