package org.example.Creatures

import Projectmon.EntryProjectmon

object Entries {
    // creatureEntries maps CreatureNames to CreatureEntries and contains the values for all creatures.
    private val creatureEntries : Map<ProjectmonIdentifier, EntryProjectmon> = mapOf(
        ProjectmonIdentifier.MISSINGNO to EntryProjectmon(
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
            Pair(-1, ProjectmonIdentifier.MISSINGNO)
        ),

        ProjectmonIdentifier.EMPTY to EntryProjectmon(
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
            Pair(-1, ProjectmonIdentifier.MISSINGNO)
        ),

        ProjectmonIdentifier.PIKAMAN to EntryProjectmon(
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
            Pair(-1, ProjectmonIdentifier.MISSINGNO)
        )
    )

    private val moveEntries : Map<ProjectmonMove, EntryMove> = mapOf(
        ProjectmonMove.MISSINGNO to EntryMove(
            "MissingNo",
            ProjectmonType.EMPTY,
            0,
            0
        ),
        ProjectmonMove.EMPTY to EntryMove(
            "",
            ProjectmonType.EMPTY,
            0,
            0
        )
    )

    // Returns a valid projectmon if id exists, otherwise returns MissingNo
    public fun getCreature(value: ProjectmonIdentifier) : EntryProjectmon {
        val entry : EntryProjectmon? = creatureEntries[value]
        return if (entry == null) creatureEntries[ProjectmonIdentifier.MISSINGNO] as EntryProjectmon else entry as EntryProjectmon
    }

    // Returns a valid move if id exists, otherwise returns MissingNo
    public fun getMove(value: ProjectmonMove) : EntryMove {
        val entry : EntryMove? = moveEntries[value]
        return if (entry == null) moveEntries[ProjectmonMove.MISSINGNO] as EntryMove else entry as EntryMove
    }
}