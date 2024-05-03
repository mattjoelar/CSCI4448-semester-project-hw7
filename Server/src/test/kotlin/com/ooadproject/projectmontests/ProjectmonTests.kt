package com.ooadproject.projectmontests

import org.example.Creatures.Projectmon
import org.example.Creatures.ProjectmonIdentifier
import org.example.Projectmon.ProjectmonFactory
import org.junit.jupiter.api.Test

class ProjectmonTests {

    @Test
    fun testGenerate() {
        val newProjectmon : Projectmon = ProjectmonFactory.generateNewProjectmon(ProjectmonIdentifier.PIKAMAN, 5)
        assert(newProjectmon.currentData == newProjectmon.baseData)
    }
}