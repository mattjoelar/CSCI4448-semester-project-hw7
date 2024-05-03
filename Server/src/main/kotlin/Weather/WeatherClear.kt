package org.example.Weather

import org.example.Creatures.Projectmon

class WeatherClear : WeatherBase() {
    override val message : String = ""
    override fun apply(pjmn1: Projectmon, pjmn2: Projectmon): Array<String> {
        // Do nothing
        return arrayOf<String>("","")
    }
}