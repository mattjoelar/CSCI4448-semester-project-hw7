package org.example.Weather

import org.example.Creatures.Entries
import org.example.Creatures.Projectmon
import org.example.Creatures.ProjectmonType
import kotlin.random.Random

class WeatherHail : WeatherBase() {
    override val message : String = "It's hailing bricks!"

    override fun apply(pjmn1: Projectmon, pjmn2: Projectmon): Array<String> {
        val ret : Array<String> = arrayOf<String>(message,"","")

        var iterator : Int = 1
        for(pjmn in arrayOf<Projectmon>(pjmn1, pjmn2)) {
            if(Entries.lookupProjectmon(pjmn.identifier).isOfType(ProjectmonType.ICE)) { continue; }

            val damage : Float = Random.nextFloat() * pjmn1.health * 0.1f
            pjmn.health -= damage
            ret[iterator] = "${pjmn.identifier} was pummeled by hail for $damage damage!"
            iterator++
        }

        return ret
    }
}