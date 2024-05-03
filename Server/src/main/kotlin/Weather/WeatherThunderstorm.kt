package org.example.Weather

import Projectmon.EntryProjectmon
import org.example.Creatures.Entries
import org.example.Creatures.Projectmon
import org.example.Creatures.ProjectmonType
import kotlin.math.min
import kotlin.random.Random

class WeatherThunderstorm : WeatherBase() {
    override val message : String = "Thunder echoes around the battlefield!"

    override fun apply(pjmn1: Projectmon, pjmn2: Projectmon): Array<String> {
        val ret : Array<String> = arrayOf<String>(message,"","")

        var iterator : Int = 1
        for(pjmn in arrayOf<Projectmon>(pjmn1, pjmn2)) {
            val damage : Float = Random.nextFloat() * pjmn1.health * 0.5f
            val entry : EntryProjectmon = Entries.lookupProjectmon(pjmn.identifier)

            if(entry.isOfType(ProjectmonType.ELECTRIC) || entry.isOfType(ProjectmonType.TECH)) {
                ret[iterator] = "${pjmn.identifier} was energized by lightning and healed ${min(pjmn.maxhealth - pjmn.health, damage)} health!"
                pjmn.health += damage
            } else {
                ret[iterator] = "${pjmn.identifier} was struck by lightning for $damage damage!"
                pjmn.health -= damage
            }

            iterator++
        }

        return ret
    }
}