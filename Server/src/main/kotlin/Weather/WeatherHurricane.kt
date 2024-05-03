package org.example.Weather

import Projectmon.Projectmon
import kotlin.random.Random

class WeatherHurricane : WeatherBase() {
    override val message = "Hold onto something, it's hell out here!"
    override fun apply(pjmn1: Projectmon, pjmn2: Projectmon): Array<String> {
        val ret : Array<String> = arrayOf<String>(message,"","")

        var iterator : Int = 1
        for(pjmn in arrayOf<Projectmon>(pjmn1, pjmn2)) {
            if(Random.nextFloat() < 0.9) { continue; }
            ret[iterator] = "${pjmn.identifier} was swept away by the hurricane!"
            pjmn.health = 0f
            iterator++
        }

        return ret
    }
}