package org.example.Creatures

import org.example.Creatures.ProjectmonIdentifier.MISSINGNO

enum class ProjectmonMove(val value: Int) {
    MISSINGNO(-1),

    EMPTY(0),

    TICKLE(1),
    SCRATCH(2),
    FLAMETHROWER(3),
    FLYING_KNEE(4);

    companion object {
        fun getIdentifier(value: Int): ProjectmonMove {
            return ProjectmonMove.entries.find{it.value == value} ?: org.example.Creatures.ProjectmonMove.MISSINGNO
        }
    }
}