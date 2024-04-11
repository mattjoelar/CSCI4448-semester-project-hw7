package org.example.Creatures

import org.example.CreatureData.CreatureMove

data class CreatureEntry(
    val name : String,
    val type1 : CreatureType,
    val type2 : CreatureType,
    val baseHealth : Int,
    val healthGrowth : Pair<Float, Float>,
    val baseAttack : Int,
    val attackGrowth : Pair<Float, Float>,
    val baseDefense : Int,
    val defenseGrowth : Pair<Float, Float>,
    val baseSpeed : Int,
    val speedGrowth : Pair<Float, Float>,
    val learnableMoves : Map<Int, CreatureMove>
)