package org.example.MoveEffects

import org.example.Arena
import Projectmon.Projectmon
import Projectmon.ProjectmonType
import kotlin.random.Random

class DamageDecorator(values: Map<String, String>) : MoveDecorator(values) {
    override fun apply(self: Projectmon, enemy: Projectmon, arena: Arena, moveType : ProjectmonType) : Array<String> {
        val power : Float = values["power"]?.toFloat() ?: 0f
        val accuracy : Float = values["accuracy"]?.toFloat() ?: 100f
        if(Random.nextFloat() * 100 < accuracy) {
            val damage: Float = ((2 * (self.currentData.level / 5) * typeModifier(
                moveType,
                enemy
            ) * power * (self.currentData.attack / enemy.currentData.defense)) / 50) + 2
            val fromHealth = enemy.health
            enemy.health -= damage
            val damageDealt = fromHealth - enemy.health

            return arrayOf<String>("${enemy.getName()} took $damageDealt damage!")
        }
        return arrayOf<String>("${self.getName()} missed!")
    }
}