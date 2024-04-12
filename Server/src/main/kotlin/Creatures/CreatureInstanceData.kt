package org.example.Creatures

import org.example.CreatureData.CreatureMove

class CreatureInstanceData(
    var name : CreatureName = CreatureName.EMPTY,
    var level : Int = 0,
    var xp : Int = 0,
    var xpMax : Int = 0,
    var health : Float = 0f,
    var attack : Float = 0f,
    var defense : Float = 0f,
    var speed : Float = 0f,
    var moves : Array<CreatureMove> = Array<CreatureMove>(4) { CreatureMove.NONE },
    var pp : Array<Int> = Array<Int>(4) { 0 },
    var statusEffects : MutableList<CreatureStatusEffect> = mutableListOf<CreatureStatusEffect>()) {


    fun levelUp(newLevel : Int) {
        var entry : CreatureEntry = Entries.getCreature(name)
        throw Exception("Not yet implemented!")
    }
}