package org.example.Creatures

import org.example.CreatureData.CreatureMove

object Entries {
    private val creatureEntries : Map<CreatureName, CreatureEntry> = mapOf(
        CreatureName.MISSINGNO to CreatureEntry(
            "MissingNo",
            CreatureType.NONE,
            CreatureType.NONE,
            1,
            Pair(0f, 1f),
            1,
            Pair(0f,0f),
            1,
            Pair(0f,0f),
            1,
            Pair(0f,0f),
            mapOf(
                1 to CreatureMove.TICKLE
            )
        ),
        CreatureName.PIKAMAN to CreatureEntry(
          "Pikaman",
            CreatureType.ELECTRIC,
            CreatureType.FERAL,
            5,
            Pair(0f, 1f),
            5,
            Pair(0f, 1f),
            5,
            Pair(0f, 1f),
            5,
            Pair(0f, 1f),
            mapOf(
                1 to CreatureMove.TICKLE,
                5 to CreatureMove.SCRATCH,
                10 to CreatureMove.FLAMETHROWER,
                15 to CreatureMove.FLYING_KNEE
            )
        )
    )

    private val moveEntries : Map<CreatureMove, MoveEntry> = mapOf(
        CreatureMove.MISSINGNO to MoveEntry(
            "MissingNo",
            CreatureType.NONE,
            0,
            0
        ),
        CreatureMove.NONE to MoveEntry(
            "",
            CreatureType.NONE,
            0,
            0
        )
    )

    // Returns a valid projectmon if id exists, otherwise returns MissingNo
    public fun getCreature(value: CreatureName) : CreatureEntry {
        val entry : CreatureEntry? = creatureEntries[value]
        return if (entry == null) creatureEntries[CreatureName.MISSINGNO] as CreatureEntry else entry as CreatureEntry
    }

    // Returns a valid move if id exists, otherwise returns MissingNo
    public fun getMove(value: CreatureMove) : MoveEntry? {
        val entry : MoveEntry? = moveEntries[value]
        return if (entry == null) moveEntries[CreatureMove.MISSINGNO] as MoveEntry else entry as MoveEntry
    }
}