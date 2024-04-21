package org.example.Creatures

import Projectmon.EntryProjectmon

object Entries {
    // creatureEntries maps CreatureNames to CreatureEntries and contains the values for all creatures.
    private val creatureEntries : Map<ProjectmonName, EntryProjectmon> = mapOf(
        ProjectmonName.MISSINGNO to EntryProjectmon(
            "MissingNo",
            ProjectmonType.EMPTY,
            ProjectmonType.EMPTY,
            1f,
            Pair(0f, 1f),
            1f,
            Pair(0f,0f),
            1f,
            Pair(0f,0f),
            1f,
            Pair(0f,0f),
            mapOf(
                1 to ProjectmonMove.TICKLE
            ),
            Pair(-1, ProjectmonName.MISSINGNO)
        ),

        ProjectmonName.EMPTY to EntryProjectmon(
            "",
            ProjectmonType.EMPTY,
            ProjectmonType.EMPTY,
            0f,
            Pair(0f, 0f),
            0f,
            Pair(0f,0f),
            0f,
            Pair(0f,0f),
            0f,
            Pair(0f,0f),
            mapOf(),
            Pair(-1, ProjectmonName.MISSINGNO)
        ),

        ProjectmonName.PIKAMAN to EntryProjectmon(
            "Pikaman",
            ProjectmonType.ELECTRIC,
            ProjectmonType.FERAL,
            5f,
            Pair(0f, 1f),
            5f,
            Pair(0f, 1f),
            5f,
            Pair(0f, 1f),
            5f,
            Pair(0f, 1f),
            mapOf(
                1 to ProjectmonMove.TICKLE,
                5 to ProjectmonMove.SCRATCH,
                10 to ProjectmonMove.FLAMETHROWER,
                15 to ProjectmonMove.FLYING_KNEE
            ),
            Pair(-1, ProjectmonName.MISSINGNO)
        )
    )

    private val moveEntries : Map<ProjectmonMove, EntryMove> = mapOf(
        ProjectmonMove.MISSINGNO to EntryMove("MissingNo",
            ProjectmonType.EMPTY, 0, 0
        ),
        ProjectmonMove.EMPTY to EntryMove("",
            ProjectmonType.EMPTY, 0, 0
        ),
        ProjectmonMove.TICKLE to EntryMove("Tickle",
            ProjectmonType.FERAL, 25, 1
        ),
        ProjectmonMove.SCRATCH to EntryMove("Scratch",
            ProjectmonType.FERAL, 20, 5
        ),
        ProjectmonMove.FLAMETHROWER to EntryMove("Flamethrower",
            ProjectmonType.FIRE, 20, 15
        ),
        ProjectmonMove.FLYING_KNEE to EntryMove("Flying Knee",
            ProjectmonType.LIGHT, 1, 55
        ),
    )

    // Returns a valid projectmon if id exists, otherwise returns MissingNo
    public fun getCreature(value: ProjectmonName) : EntryProjectmon {
        val entry : EntryProjectmon? = creatureEntries[value]
        return if (entry == null) creatureEntries[ProjectmonName.MISSINGNO] as EntryProjectmon else entry as EntryProjectmon
    }

    // Returns a valid move if id exists, otherwise returns MissingNo
    public fun getMove(value: ProjectmonMove) : EntryMove {
        val entry : EntryMove? = moveEntries[value]
        return if (entry == null) moveEntries[ProjectmonMove.MISSINGNO] as EntryMove else entry as EntryMove
    }
}