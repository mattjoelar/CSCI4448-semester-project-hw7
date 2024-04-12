package Projectmon

import org.example.Creatures.ProjectmonMove
import org.example.Creatures.ProjectmonName
import org.example.Creatures.ProjectmonType
import kotlin.math.pow
import kotlin.random.Random

data class EntryProjectmon(
    val name : String,
    val type1 : ProjectmonType,
    val type2 : ProjectmonType,
    val baseHealth : Float,
    val healthGrowth : Pair<Float, Float>,
    val baseAttack : Float,
    val attackGrowth : Pair<Float, Float>,
    val baseDefense : Float,
    val defenseGrowth : Pair<Float, Float>,
    val baseSpeed : Float,
    val speedGrowth : Pair<Float, Float>,
    val learnableMoves : Map<Int, ProjectmonMove>,
    val evolvesAtLevelInto : Pair<Int, ProjectmonName>
) {
    private fun generateStatIncrease(growth : Pair<Float, Float>, levels : Int) : Float {
        return levels * (growth.first + (growth.second - growth.first) * Random.nextFloat())
    }

    public fun generateHealthIncrease(levels : Int) : Float {
        return generateStatIncrease(healthGrowth, levels)
    }
    public fun generateAttackIncrease(levels : Int) : Float {
        return generateStatIncrease(attackGrowth, levels)
    }
    public fun generateDefenseIncrease(levels : Int) : Float {
        return generateStatIncrease(defenseGrowth, levels)
    }
    public fun generateSpeedIncrease(levels : Int) : Float {
        return generateStatIncrease(speedGrowth, levels)
    }
    public fun getXpNeededForNextLevel(level : Int) : Int {
        // Change from MAX_VALUE to something else later
        // 100 + 10x + 2^(1+.1x)
        return if (level == 100) Int.MAX_VALUE else (100 + (10f * level) + 2f.pow(1f + level.toFloat() * 0.1f)).toInt()
    }
}