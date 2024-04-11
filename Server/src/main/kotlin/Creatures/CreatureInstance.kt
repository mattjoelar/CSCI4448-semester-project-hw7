package org.example.Creatures

import org.example.CreatureData.CreatureMove

data class CreatureInstanceData(
    var name : CreatureName = CreatureName.MISSINGNO,
    var level : Int = 1,
    var xp : Int = 0,
    var health : Int = 0,
    var attack : Int = 0,
    var defense : Int = 0,
    var speed : Int = 0,
    var moves : Array<CreatureMove> = Array<CreatureMove>(4) { CreatureMove.NONE },
    var pp : Array<Int> = Array<Int>(4) { 0 },
    var statusEffects : MutableList<CreatureStatusEffect> = mutableListOf<CreatureStatusEffect>()
)

class CreatureInstance(data: CreatureInstanceData) {

    public var baseData : CreatureInstanceData = data
    public var currentData : CreatureInstanceData = data

    public fun levelUp(amount : Int) {

    }

    //public var curHealth = maxHealth
    //    set(newHealth) {
    //        field = min(maxHealth, max(newHealth, 0))
    //    }
}

class CreatureInstanceFactory {
    companion object {
        fun createCreatureInstance(name : CreatureName, level : Int) : CreatureInstance {
            //var creatureEntry = Entries.getCreature(name)
            //val creatureInstance = CreatureInstance(creatureEntry)
            //return CreatureInstance(creatureEntry)
            throw Exception("Not implemented yet")
        }
    }
}