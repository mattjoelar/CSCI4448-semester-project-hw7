package org.example.Weather

import org.example.Creatures.Projectmon

/* STRATEGY PATTERN
Since weather can have complex interactions on the battle depending on many external factors, it made sense
to make use of the strategy pattern here. Weather subclasses all implement an "apply" abstract function which
can vary wildly in function, but must always return an array of strings that describe what happened this
turn due to weather.
*/
abstract class WeatherBase {
    abstract val message : String

    // Does something to both projectmon. Returns messages to print.
    abstract fun apply(pjmn1 : Projectmon, pjmn2 : Projectmon) : Array<String>
}