package Projectmon

import org.example.MoveEffects.MoveDecorator
import org.example.MoveEffects.DamageDecorator
import org.example.MoveEffects.StatusDecorator
import org.example.MoveEffects.WeatherDecorator

object Entries {
    // creatureEntries maps CreatureNames to CreatureEntries and contains the values for all creatures.
    private val projectmonEntries : Map<ProjectmonIdentifier, EntryProjectmon> = mapOf(
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
            ProjectmonType.MISSINGNO,
            0,
            arrayOf<MoveDecorator>()
        ),
        ProjectmonMove.EMPTY to EntryMove(
            "",
            ProjectmonType.EMPTY,
            0,
            arrayOf<MoveDecorator>()
        ),
        ProjectmonMove.TICKLE to EntryMove(
            "Tickle",
            ProjectmonType.FERAL,
            30,
            arrayOf<MoveDecorator>(
                DamageDecorator(
                    mapOf<String, String>("Power" to "1")
                )
            )
        ),
        ProjectmonMove.SCRATCH to EntryMove(
            "Scratch",
            ProjectmonType.FERAL,
            20,
            arrayOf<MoveDecorator>(
                DamageDecorator(
                    mapOf<String, String>("power" to "5")
                )
            )
        ),
        ProjectmonMove.FLAMETHROWER to EntryMove(
            "Flamethrower",
            ProjectmonType.FIRE,
            10,
            arrayOf<MoveDecorator>(
                DamageDecorator(
                    mapOf<String, String>("power" to "5", "accuracy" to "75")
                ),
                StatusDecorator(
                    mapOf<String, String>("status" to "${ProjectmonStatus.BURN.value}", "accuracy" to "33")
                )
            )
        ),
        ProjectmonMove.FLYING_KNEE to EntryMove(
            "Flying Knee",
            ProjectmonType.LIGHT,
            1,
            arrayOf<MoveDecorator>(
                DamageDecorator(
                    mapOf<String, String>("power" to "1000", "accuracy" to "50")
                ),
                StatusDecorator(
                    mapOf<String, String>("status" to "${ProjectmonStatus.PARALYZE.value}")
                )
            )
        ),
        ProjectmonMove.THUNDER_DANCE to EntryMove(
            "Thunder Dance",
            ProjectmonType.MAGIC,
            3,
            arrayOf<MoveDecorator>(
                WeatherDecorator(
                    mapOf<String, String>("weather" to "thunderstorm", "accuracy" to "90")
                )
            )
        )
    )


    // Returns a valid projectmon if id exists, otherwise returns MissingNo
    public fun lookupProjectmon(value: ProjectmonIdentifier) : EntryProjectmon {
        val entry : EntryProjectmon? = projectmonEntries[value]
        return if (entry == null) projectmonEntries[ProjectmonIdentifier.MISSINGNO] as EntryProjectmon else entry as EntryProjectmon
    }

    // Returns a valid move if id exists, otherwise returns MissingNo
    public fun lookupMove(value: ProjectmonMove) : EntryMove {
        val entry : EntryMove? = moveEntries[value]
        return if (entry == null) moveEntries[ProjectmonMove.MISSINGNO] as EntryMove else entry as EntryMove
    }

    public fun lookupEffectiveness(from : ProjectmonType, against : ProjectmonType) : Float {
        return when(from) {
            ProjectmonType.MISSINGNO -> 1f
            ProjectmonType.EMPTY -> 1f
            ProjectmonType.LIGHT -> {
                when(against) {
                    ProjectmonType.DARK -> 2f
                    ProjectmonType.PLANT -> -1f
                    else -> 1f
                }
            }
            ProjectmonType.AIR -> {
                when(against) {
                    ProjectmonType.FIRE -> 2f
                    else -> 1f
                }
            }
            ProjectmonType.DARK -> {
                when(against) {
                    ProjectmonType.FIRE -> 0.5f
                    ProjectmonType.PLANT -> 2f
                    else -> 1f
                }
            }
            ProjectmonType.PLANT -> {
                when(against) {
                    ProjectmonType.WATER -> 2f
                    ProjectmonType.FERAL -> 0.5f
                    ProjectmonType.EARTH -> 2f
                    else -> 1f
                }
            }
            ProjectmonType.FERAL -> {
                when(against) {
                    ProjectmonType.FERAL -> 2f
                    ProjectmonType.PLANT -> 2f
                    ProjectmonType.DARK -> 0.5f
                    ProjectmonType.TECH -> 0.5f
                    ProjectmonType.MAGIC -> 2f
                    else -> 1f
                }
            }
            ProjectmonType.TECH -> {
                when(against) {
                    ProjectmonType.FERAL -> 2f
                    else -> 1f
                }
            }
            ProjectmonType.MAGIC -> {
                when(against) {
                    ProjectmonType.TECH -> 0.5f
                    ProjectmonType.MAGIC -> 0.5f
                    // They control the basic elements I guess
                    ProjectmonType.FIRE -> 2f
                    ProjectmonType.ICE -> 2f
                    else -> 1f
                }
            }
            ProjectmonType.FIRE -> {
                when(against) {
                    ProjectmonType.PLANT -> 2f
                    ProjectmonType.CRINGE -> 2f
                    else -> 1f
                }
            }
            ProjectmonType.EARTH -> {
                when(against) {
                    ProjectmonType.FIRE -> 2f
                    ProjectmonType.ELECTRIC -> 0f
                    else -> 1f
                }
            }
            ProjectmonType.ICE -> {
                when(against) {
                    ProjectmonType.PLANT -> 2f
                    ProjectmonType.WATER -> 2f
                    else -> 1f
                }
            }
            ProjectmonType.WATER -> {
                when(against) {
                    ProjectmonType.FIRE -> 2f
                    ProjectmonType.TECH -> 2f
                    ProjectmonType.EARTH -> 2f
                    else -> 1f
                }
            }
            ProjectmonType.CRINGE -> {
                when(against) {
                    ProjectmonType.DARK -> 2f
                    ProjectmonType.FERAL -> 0.5f
                    ProjectmonType.LIGHT -> 0.5f
                    else -> 1f
                }
            }
            ProjectmonType.ELECTRIC -> {
                when(against) {
                    ProjectmonType.TECH -> 2f
                    ProjectmonType.WATER -> 2f
                    ProjectmonType.FERAL -> 2f
                    ProjectmonType.EARTH -> 0f
                    ProjectmonType.AIR -> 0f
                    ProjectmonType.LIGHT -> 0.5f
                    else -> 1f
                }
            }
            else -> 1f
        }
    }
}