package org.example.Creatures

import org.example.CreatureData.CreatureMove

data class CreatureEntry(
    val name : String,
    val type1 : CreatureType,
    val type2 : CreatureType,
    val baseHealth : Float,
    val healthGrowth : Pair<Float, Float>,
    val baseAttack : Float,
    val attackGrowth : Pair<Float, Float>,
    val baseDefense : Float,
    val defenseGrowth : Pair<Float, Float>,
    val baseSpeed : Float,
    val speedGrowth : Pair<Float, Float>,
    val learnableMoves : Map<Int, CreatureMove>,
    val evolvesAtLevelInto : Pair<Int, CreatureName>
)