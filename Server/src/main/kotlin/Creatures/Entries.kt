package org.example.Creatures

import org.example.Creatures.EntryCreature
import org.example.Creatures.EntryMove

object Entries {
    // creatureEntries maps CreatureNames to CreatureEntries and contains the values for all creatures.
    private val creatureEntries : Map<CreatureName, EntryCreature> = mapOf(
        CreatureName.MISSINGNO to EntryCreature(
            "MissingNo",
            CreatureType.NONE,
            CreatureType.NONE,
            1f,
            Pair(0f, 1f),
            1f,
            Pair(0f,0f),
            1f,
            Pair(0f,0f),
            1f,
            Pair(0f,0f),
            mapOf(
                1 to CreatureMove.TICKLE
            ),
            Pair(-1, CreatureName.MISSINGNO)
        ),

        CreatureName.EMPTY to EntryCreature(
            "",
            CreatureType.NONE,
            CreatureType.NONE,
            0f,
            Pair(0f, 0f),
            0f,
            Pair(0f,0f),
            0f,
            Pair(0f,0f),
            0f,
            Pair(0f,0f),
            mapOf(),
            Pair(-1, CreatureName.MISSINGNO)
        ),

        CreatureName.PIKAMAN to EntryCreature(
            "Pikaman",
            CreatureType.ELECTRIC,
            CreatureType.FERAL,
            5f,
            Pair(0f, 1f),
            5f,
            Pair(0f, 1f),
            5f,
            Pair(0f, 1f),
            5f,
            Pair(0f, 1f),
            mapOf(
                1 to CreatureMove.TICKLE,
                5 to CreatureMove.SCRATCH,
                10 to CreatureMove.FLAMETHROWER,
                15 to CreatureMove.FLYING_KNEE
            ),
            Pair(-1, CreatureName.MISSINGNO)
        )
    )

    private val moveEntries : Map<CreatureMove, EntryMove> = mapOf(
        CreatureMove.MISSINGNO to EntryMove(
            "MissingNo",
            CreatureType.NONE,
            0,
            0
        ),
        CreatureMove.NONE to EntryMove(
            "",
            CreatureType.NONE,
            0,
            0
        )
    )

    // Returns a valid projectmon if id exists, otherwise returns MissingNo
    public fun getCreature(value: CreatureName) : EntryCreature {
        val entry : EntryCreature? = creatureEntries[value]
        return if (entry == null) creatureEntries[CreatureName.MISSINGNO] as EntryCreature else entry as EntryCreature
    }

    // Returns a valid move if id exists, otherwise returns MissingNo
    public fun getMove(value: CreatureMove) : EntryMove {
        val entry : EntryMove? = moveEntries[value]
        return if (entry == null) moveEntries[CreatureMove.MISSINGNO] as EntryMove else entry as EntryMove
    }
}