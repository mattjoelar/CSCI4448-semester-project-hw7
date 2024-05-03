package com.ooadproject.projectmontests

import Projectmon.*
import org.example.Battle
import org.example.Player
import org.example.Projectmon.ProjectmonFactory
import org.junit.jupiter.api.Test

class ProjectmonTests {
    @Test
    fun testProjectmon() {
        val newProjectmon : Projectmon = ProjectmonFactory.generateNewProjectmon(ProjectmonIdentifier.PIKAMAN, 5)
        assert(newProjectmon.currentData.identifier == ProjectmonIdentifier.PIKAMAN)
        assert(newProjectmon.currentData == newProjectmon.baseData)
        assert(newProjectmon.currentData.level == 5)
        assert(!newProjectmon.isDead())
        assert(newProjectmon.health == newProjectmon.currentData.health)
        assert(newProjectmon.health == newProjectmon.maxHealth)
        val health : Float = newProjectmon.health
        newProjectmon.health -= 1f
        assert((health - newProjectmon.health) == 1f)
        newProjectmon.health += 1f
        assert(newProjectmon.identifier == newProjectmon.currentData.identifier)
        assert(newProjectmon.getName() == Entries.lookupProjectmon(newProjectmon.currentData.identifier).name)

        val otherNewProjectmon : Projectmon = ProjectmonFactory.generateNewProjectmon(ProjectmonIdentifier.PIKAMAN, 10)

        val testEntry : EntryProjectmon = Entries.lookupProjectmon(ProjectmonIdentifier.PIKAMAN)
        assert(testEntry.generateHealthIncrease(1) in testEntry.healthGrowth.first..testEntry.healthGrowth.second)
        assert(testEntry.generateAttackIncrease(1) in testEntry.attackGrowth.first..testEntry.attackGrowth.second)
        assert(testEntry.generateDefenseIncrease(1) in testEntry.defenseGrowth.first..testEntry.defenseGrowth.second)
        assert(testEntry.generateSpeedIncrease(1) in testEntry.speedGrowth.first..testEntry.speedGrowth.second)
        assert(testEntry.isOfType(ProjectmonType.ELECTRIC))
        assert(!testEntry.isOfType(ProjectmonType.CRINGE))
        assert(testEntry.getXpNeededForNextLevel(1) > 0)

        val player1 : Player = Player()
        player1.projectmons = arrayOf<Projectmon>(newProjectmon, newProjectmon, newProjectmon, newProjectmon, newProjectmon, newProjectmon)

        val player2 : Player = Player()
        player2.projectmons = arrayOf<Projectmon>(otherNewProjectmon, otherNewProjectmon, otherNewProjectmon, otherNewProjectmon, otherNewProjectmon, otherNewProjectmon)

        val battle : Battle = Battle(player1, player2)
        assert(battle.useMove(player1, player2, 0).wasSuccessful)
        assert(battle.switchProjectmon(player1, 1).wasSuccessful)






        assert(battle.playerForfeit(player1).wasSuccessful)
    }


}