package org.example.Creatures

import org.example.Creatures.CreatureMove
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

class Creature(data : CreatureData) {
    private var baseData : CreatureData = data
    private var currentData : CreatureData = data

    public var _health : Float
        get() {
            return currentData.health
        }
        set(newHealth : Float) {
            currentData.health = min(baseData.health, max(newHealth, 0f))
        }

    public fun levelUp(amount : Int) {

    }
}

class CreatureFactory {
    companion object {
        fun generateNewCreature(name : CreatureName, level : Int) : Creature {
            // Get entry from Entries for this creature
            val entry : EntryCreature = Entries.getCreature(name)

            val clampedLevel : Int = level.coerceIn(1, 100)
            val moves: Array<CreatureMove> = Array<CreatureMove>(4) { CreatureMove.EMPTY }
            val pp: Array<Int> = Array<Int>(4) { 0 }

            // Generate moves for the creature from random moves it could have learned
            val learnableMoves = entry.learnableMoves.toList()
            val validMoves : MutableList<CreatureMove> = mutableListOf<CreatureMove>();
            for(levelMovePair in learnableMoves) {
                if(levelMovePair.first <= clampedLevel) {
                    validMoves.add(levelMovePair.second)
                }
            }
            for(i in 0..min(entry.learnableMoves.size - 1, 3) ) {
                val randomMove = validMoves[Random.nextInt(validMoves.size)]
                moves[i] = randomMove
                pp[i] = Entries.getMove(randomMove).pp
                validMoves.removeAt(i)
            }

            // Create CreatureInstanceData for new creature
            fun levelToStat(base : Float, growthMin : Float, growthMax : Float, level : Int) : Float {
                return base + level * (growthMin + (growthMax - growthMin) * Random.nextFloat())
            }
            val instanceData : CreatureData = CreatureData(
                name,
                clampedLevel,
                0,
                0,
                levelToStat(entry.baseHealth, entry.healthGrowth.first, entry.healthGrowth.second, clampedLevel),
                levelToStat(entry.baseAttack, entry.attackGrowth.first, entry.attackGrowth.second, clampedLevel),
                levelToStat(entry.baseDefense, entry.defenseGrowth.first, entry.defenseGrowth.second, clampedLevel),
                levelToStat(entry.baseSpeed, entry.speedGrowth.first, entry.speedGrowth.second, clampedLevel),
                moves,
                pp,
                mutableListOf<CreatureStatusEffect>()
            )

            return Creature(instanceData)
        }
    }
}