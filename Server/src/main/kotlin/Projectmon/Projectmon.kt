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
    public fun isDead(): Boolean {
        return health == 0f
    }
    public fun getPpOfMove(idx : Int) : Int {
        return if(idx in 0..3) currentData.pp[idx] else 0
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