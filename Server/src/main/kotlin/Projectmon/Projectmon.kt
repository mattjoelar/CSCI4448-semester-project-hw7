package Projectmon

import org.example.Arena
import kotlin.math.max
import kotlin.math.min

class Projectmon {
    // These shouldn't be public, but it's too annoying to not do so
    public lateinit var baseData : ProjectmonData
    public lateinit var currentData : ProjectmonData

    constructor() {
        baseData = ProjectmonData()
        currentData = ProjectmonData()
    }
    constructor(data : ProjectmonData) {
        baseData = data.copy();
        currentData = data.copy();
    }

    public fun getName() : String {
        return Entries.lookupProjectmon(currentData.identifier).name
    }

    // Data accessors
    public var health : Float
        get() {
            return currentData.health
        }
        set(newHealth : Float) {
            currentData.health = min(baseData.health, max(newHealth, 0f))
        }
    public val identifier : ProjectmonIdentifier
        get() {
            return currentData.identifier
        }
    public val maxHealth : Float
        get() {
            return baseData.health
        }
    public fun isDead(): Boolean {
        return health == 0f
    }
    public fun getMove(idx : Int) : ProjectmonMove {
        return currentData.moves[idx]
    }
    public fun getPpOfMove(idx : Int) : Int {
        return if(idx in 0..3) currentData.pp[idx] else 0
    }

    public fun useMoveAgainst(moveIdx: Int, against: Projectmon, arena : Arena) : Array<String> {
        if(getPpOfMove(moveIdx) < 0) {
            return arrayOf("Error: Move has no PP, this should not have been able to be called!")
        }
        val moveData = Entries.lookupMove(currentData.moves[moveIdx])

        return moveData.use(this, against, arena)
    }

    // This needs to be updated to include evolutions!
    public fun levelUp(to : Int) {
        val levelsGained : Int = to - baseData.level
        if(levelsGained < 0 || to > 100) {
            return
        }

        val entry : EntryProjectmon = Entries.lookupProjectmon(baseData.identifier)

        // Check if this projectmon needs to evolve
        baseData.level = to
        if(entry.evolvesAtLevelInto.first > 0 && entry.evolvesAtLevelInto.first <= baseData.level) {
            baseData.identifier = entry.evolvesAtLevelInto.second
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