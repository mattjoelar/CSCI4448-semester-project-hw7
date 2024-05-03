package Projectmon

enum class ProjectmonMove(val value: Int) {
    MISSINGNO(-1),

    EMPTY(0),

    TICKLE(1),
    SCRATCH(2),
    FLAMETHROWER(3),
    FLYING_KNEE(4),
    THUNDER_DANCE(5);

    companion object{

        fun getIdentifier(value: Int): ProjectmonMove {
            return entries.find{it.value == value} ?: MISSINGNO
        }
    }
}