package org.example.Projectmon

import Projectmon.EntryProjectmon
import org.example.Creatures.*
import kotlin.math.min
import kotlin.random.Random

class ProjectmonFactory {
    companion object {
        fun generateNewCreature(name: ProjectmonName, level: Int): Projectmon {
            // Get entry from Entries for this creature
            val entry: EntryProjectmon = Entries.getCreature(name)

            val clampedLevel: Int = level.coerceIn(1, 100)
            val moves: Array<ProjectmonMove> = Array<ProjectmonMove>(4) { ProjectmonMove.EMPTY }
            val pp: Array<Int> = Array<Int>(4) { 0 }

            // Generate moves for the creature from random moves it could have learned
            val learnableMoves = entry.learnableMoves.toList()
            val validMoves: MutableList<ProjectmonMove> = mutableListOf<ProjectmonMove>();
            for (levelMovePair in learnableMoves) {
                if (levelMovePair.first <= clampedLevel) {
                    validMoves.add(levelMovePair.second)
                }
            }
            for (i in 0..min(entry.learnableMoves.size - 1, 3)) {
                val randomMove = validMoves[Random.nextInt(validMoves.size)]
                moves[i] = randomMove
                pp[i] = Entries.getMove(randomMove).pp
                validMoves.removeAt(i)
            }

            // Create CreatureInstanceData for new creature
            fun levelToStat(base: Float, growthMin: Float, growthMax: Float, level: Int): Float {
                return base + level * (growthMin + (growthMax - growthMin) * Random.nextFloat())
            }

            val instanceData: ProjectmonData = ProjectmonData(
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