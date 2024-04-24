package com.ooadproject.projectmonDB.controller;

import com.ooadproject.projectmonDB.model.party.Creature;
import com.ooadproject.projectmonDB.model.party.DBDao;
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
    private DBDao DBDao;

    //Gets all creatures from DB server
    @GetMapping("/creature/get-all")
    public List<Creature> getAllCreatures() {
        return dbDao.getAllEmployees();
    }

    //Posts to DB server
    @PostMapping("/creature/save")
    public Creature save(@RequestBody Creature creature) {
        return dbDao.save(creature);
    }
}
