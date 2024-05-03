package org.example.Projectmon

import Projectmon.EntryProjectmon
import com.ooadproject.projectmonDB.model.Creature
import com.ooadproject.projectmonDB.model.Move
import org.example.Creatures.*
import org.example.Creatures.ProjectmonMove.Companion.getIdentifier
import kotlin.random.Random

class ProjectmonFactory {
    companion object {
        fun generateNewProjectmon(name: ProjectmonIdentifier, level: Int): Projectmon {
            // Get entry from Entries for this creature
            val entry: EntryProjectmon = Entries.lookupProjectmon(name)

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
            var learnedMoves : Int = 0
            while(validMoves.size > 0 && learnedMoves < 4) {
                //println("on $name size is ${validMoves.size}")
                //println("selected index is $number")
                val number = Random.nextInt(validMoves.size)
                val randomMove = validMoves[Random.nextInt(validMoves.size)]
                moves[learnedMoves] = randomMove
                pp[learnedMoves] = Entries.lookupMove(randomMove).pp

                println("Setting $name's move $learnedMoves to $randomMove with ${pp[learnedMoves]} pp.")
                validMoves.remove(randomMove)
                learnedMoves++
                //println("size is now ${validMoves.size}")
            }
            /*for (i in 0..min(entry.learnableMoves.size - 1, 3)) {
                val randomMove = validMoves[Random.nextInt(validMoves.size)]
                moves[i] = randomMove
                pp[i] = Entries.getMove(randomMove).pp
                validMoves.removeAt(i)
            }*/

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

        fun createFromDb(creature: Creature): Projectmon {
            val moves = getMoves(creature)
            val projectmon = Projectmon()
            projectmon.baseData.name = ProjectmonIdentifier.getIdentifier(creature.id)
            projectmon.baseData.level = creature.level
            projectmon.baseData.xp = creature.xp
            projectmon.baseData.xpMax =creature.xp_max
            projectmon.baseData.health = creature.hp
            projectmon.baseData.attack = creature.attack
            projectmon.baseData.defense = creature.defense
            projectmon.baseData.speed = creature.speed
            for(i in 0..getMoves(creature).size) {
                val move = getIdentifier(moves[i].identifier)
                projectmon.baseData.moves[i] = move
                projectmon.baseData.pp[i] = (Entries.lookupMove(move)).pp
            }


            return projectmon
        }

        private fun getMoves(creature: Creature?): List<Move> {
            return creature!!.moves
        }

    }




}