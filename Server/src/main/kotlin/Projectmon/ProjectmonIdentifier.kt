package org.example.Creatures

enum class ProjectmonIdentifier(val value: Int) {
    MISSINGNO(-1),

    EMPTY(0),

    PIKAMAN(1),
    BIG_JOHN(2),
    FRIBIAN(3),
    PUPMUTT(4);

    companion object {
        fun getIdentifier(value: Int): ProjectmonIdentifier {
            return entries.find{it.value == value} ?: MISSINGNO
        }
    }


}