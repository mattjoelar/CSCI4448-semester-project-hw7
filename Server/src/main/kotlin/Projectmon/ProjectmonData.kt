package org.example.Creatures

import Projectmon.EntryProjectmon

data class ProjectmonData(
    var name: ProjectmonName = ProjectmonName.EMPTY,
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
        var entry : EntryProjectmon = Entries.lookupProjectmon(name)
        throw Exception("Not yet implemented!")
    }
}