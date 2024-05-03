package Projectmon

data class ProjectmonData(
    var identifier: ProjectmonIdentifier = ProjectmonIdentifier.EMPTY,
    var level: Int = 0,
    var xp: Int = 0,
    var xpMax: Int = 0,
    var health: Float = 0f,
    var attack: Float = 0f,
    var defense: Float = 0f,
    var speed: Float = 0f,
    var moves: Array<ProjectmonMove> = Array<ProjectmonMove>(4) { ProjectmonMove.EMPTY },
    var pp: Array<Int> = Array<Int>(4) { 0 },
    var statusEffects: MutableList<ProjectmonStatus> = mutableListOf<ProjectmonStatus>()
) {
    fun levelUp(newLevel : Int) {
        var entry : EntryProjectmon = Entries.lookupProjectmon(identifier)
        throw Exception("Not yet implemented!")
    }
}