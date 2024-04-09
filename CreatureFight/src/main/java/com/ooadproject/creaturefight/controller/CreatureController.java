package com.ooadproject.creaturefight.controller;

import com.ooadproject.creaturefight.model.creature.Creature;
import com.ooadproject.creaturefight.model.creature.CreatureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Allows SpringBoot to automatically control get/post
@RestController
public class CreatureController {

    @Autowired
    private CreatureDao creatureDao;

    //Gets all creatures from DB server
    @GetMapping("/creature/get-all")
    public List<Creature> getAllCreatures() {
        return creatureDao.getAllEmployees();
    }

    //Posts to DB server
    @PostMapping("/creature/save")
    public Creature save(@RequestBody Creature creature) {
        return creatureDao.save(creature);
    }
}
