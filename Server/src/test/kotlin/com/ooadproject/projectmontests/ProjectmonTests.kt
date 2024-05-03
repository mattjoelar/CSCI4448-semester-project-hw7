package com.ooadproject.projectmontests

import Projectmon.Projectmon
import Projectmon.ProjectmonIdentifier
import org.example.Projectmon.ProjectmonFactory
import org.junit.jupiter.api.Test

class ProjectmonTests {
    @Test
    fun testGenerateProjectmon() {
        val newProjectmon : Projectmon = ProjectmonFactory.generateNewProjectmon(ProjectmonIdentifier.PIKAMAN, 5)
        assert(newProjectmon.currentData == newProjectmon.baseData)
        assert(newProjectmon.currentData.level == 5)


    }


}