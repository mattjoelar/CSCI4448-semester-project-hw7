package org.example

import Projectmon.Projectmon
import org.example.Weather.WeatherBase
import org.example.Weather.WeatherClear

class Arena {
    private var weather : WeatherBase = WeatherClear()

    fun setWeather(newWeather : WeatherBase) {
        weather = newWeather
    }

    fun apply(pjmn1 : Projectmon, pjmn2 : Projectmon) : Array<String> {
        var ret = arrayOf<String>()

        ret += weather.apply(pjmn1, pjmn2)

        return ret
    }
}