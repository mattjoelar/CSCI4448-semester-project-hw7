package org.example

import Projectmon.Projectmon

class Player {


    // I am making the executive decision to refer to plural projectmon as "projectmons"
    // If you don't like it too bad!!! :)
    var projectmons = Array<Projectmon>(6) { Projectmon() }
    var selectedProjectmonIdx = 0
    var partyName = ""

    public fun getActiveProjectmon() : Projectmon {
        return projectmons[selectedProjectmonIdx]
    }


}