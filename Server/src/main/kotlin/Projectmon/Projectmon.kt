package org.example.Creatures

import Projectmon.EntryProjectmon
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

class Projectmon {
    private lateinit var baseData : ProjectmonData
    private lateinit var currentData : ProjectmonData

    constructor() {
        baseData = ProjectmonData()
        currentData = ProjectmonData()
    }
    constructor(data : ProjectmonData) {
        baseData = data.copy();
        currentData = data.copy();
    }

    // Data accessors
    public val name : ProjectmonName
        get() {
            return currentData.name
        }
    public var health : Float
        get() {
            return currentData.health
        }
        set(newHealth : Float) {
            currentData.health = min(baseData.health, max(newHealth, 0f))
        }
    public val maxhealth : Float
        get() {
            return baseData.health
        }
    public val attack : Float
        get() {
            return currentData.attack
        }
    public val defense : Float
        get() {
            return currentData.defense
        }
    public val speed : Float
        get() {
            return currentData.speed
        }

    // This needs to be updated to include evolutions!
    public fun levelUp(to : Int) {
        val levelsGained : Int = to - baseData.level
        if(levelsGained < 0 || to > 100) {
            return
        }

        var entry : EntryProjectmon = Entries.getCreature(baseData.name)

        // Check if this projectmon needs to evolve
        baseData.level = to
        if(entry.evolvesAtLevelInto.first > 0 && entry.evolvesAtLevelInto.first <= baseData.level) {
            baseData.name = entry.evolvesAtLevelInto.second
        }

        // Keep track of current stats to update later
        val healthRatio : Float = currentData.health / baseData.health
        val attackRatio : Float = currentData.attack / baseData.attack
        val defenseRatio : Float = currentData.defense / baseData.defense
        val speedRatio : Float = currentData.speed / baseData.speed

        // Update creature base stats
        baseData.xpMax = entry.getXpNeededForNextLevel(baseData.level)
        baseData.health += entry.generateHealthIncrease(levelsGained)
        baseData.attack += entry.generateAttackIncrease(levelsGained)
        baseData.defense += entry.generateDefenseIncrease(levelsGained)
        baseData.speed += entry.generateSpeedIncrease(levelsGained)

        // Update current stats to be same ratio to new stats as they were to old stats
        currentData.level = baseData.level
        currentData.health = healthRatio * baseData.health
        currentData.attack = attackRatio * baseData.attack
        currentData.defense = defenseRatio * baseData.defense
        currentData.speed = speedRatio * baseData.speed
    }
}

class CreatureFactory {
    companion object {
        fun generateNewCreature(name : ProjectmonName, level : Int) : Projectmon {
            // Get entry from Entries for this creature
            val entry : EntryProjectmon = Entries.getCreature(name)

            val clampedLevel : Int = level.coerceIn(1, 100)
            val moves: Array<ProjectmonMove> = Array<ProjectmonMove>(4) { ProjectmonMove.EMPTY }
            val pp: Array<Int> = Array<Int>(4) { 0 }

            // Generate moves for the creature from random moves it could have learned
            val learnableMoves = entry.learnableMoves.toList()
            val validMoves : MutableList<ProjectmonMove> = mutableListOf<ProjectmonMove>();
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
            val instanceData : ProjectmonData = ProjectmonData(
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
                mutableListOf<ProjectmonStatus>()
            )

            return Projectmon(instanceData)
        }
    }
}