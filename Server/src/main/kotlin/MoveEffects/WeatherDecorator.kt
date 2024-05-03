package org.example.MoveEffects

import org.example.Arena
import org.example.Creatures.Projectmon
import org.example.Creatures.ProjectmonType
import org.example.Weather.*
import kotlin.random.Random

class WeatherDecorator(values: Map<String, String>) : MoveDecorator(values) {
    override fun apply(self: Projectmon, enemy: Projectmon, arena: Arena, moveType: ProjectmonType): Array<String> {
        val accuracy: Float = values["accuracy"]?.toFloat() ?: 0f
        if (Random.nextFloat() * 100 < accuracy) {
            arena.setWeather(when (values["weather"]) {
                "hail" -> WeatherHail()
                "hurricane" -> WeatherHurricane()
                "thunderstorm" -> WeatherThunderstorm()
                else -> WeatherClear()
            })
        }
        return arrayOf<String>()
    }
}