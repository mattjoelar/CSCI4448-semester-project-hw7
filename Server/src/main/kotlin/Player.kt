package org.example

import org.example.Creatures.Projectmon

class Player {


    // I am making the executive decision to refer to plural projectmon as "projectmons"
    // If you don't like it too bad :)
    val projectmons = Array<Projectmon>(6) { Projectmon() }
    var selectedProjectmonIdx = 0
    var partyIdx = 0

    public fun getActiveProjectmon() : Projectmon {
        return projectmons[selectedProjectmonIdx]
    }

    public fun setPartyIDx(partyIdx: Int) {
        this.partyIdx = partyIdx
    }
}