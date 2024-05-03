package org.example.MoveEffects

import org.example.Arena
import Projectmon.Entries
import Projectmon.Projectmon
import Projectmon.ProjectmonType

open class MoveDecorator(val values: Map<String, String>) {

    open fun apply(self: Projectmon, enemy: Projectmon, arena: Arena, moveType : ProjectmonType) : Array<String> {
        println("Not implemented!")
        return arrayOf<String>("")
    }

    fun typeModifier(type : ProjectmonType, against : Projectmon) : Float {
        val againstEntry = Entries.lookupProjectmon(against.identifier)
        return Entries.lookupEffectiveness(type, againstEntry.type1) * Entries.lookupEffectiveness(type, againstEntry.type1)
    }

}