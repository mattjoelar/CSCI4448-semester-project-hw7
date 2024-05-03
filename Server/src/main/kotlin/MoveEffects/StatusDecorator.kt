package org.example.MoveEffects

import org.example.Arena
import org.example.Creatures.Entries
import org.example.Creatures.Projectmon
import org.example.Creatures.ProjectmonStatus
import org.example.Creatures.ProjectmonType
import kotlin.random.Random

class StatusDecorator(values: Map<String, String>) : MoveDecorator(values) {
    override fun apply(self: Projectmon, enemy: Projectmon, arena: Arena, moveType : ProjectmonType) : Array<String> {
        val status : ProjectmonStatus = ProjectmonStatus.entries[values["type"]?.toInt() ?: 0]
        if(Random.nextFloat() * 100f < (values["accuracy"]?.toFloat() ?: 0f)) {
            enemy.currentData.statusEffects.add(status)
            return arrayOf<String>("${Entries.lookupProjectmon(enemy.identifier).name} was inflicted with ${status}!")
        }
        return arrayOf<String>("")
    }
}