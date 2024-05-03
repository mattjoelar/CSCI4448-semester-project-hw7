package com.ooadproject.projectmonDB.controller;

import com.ooadproject.projectmonDB.dao.CreatureDao;
import com.ooadproject.projectmonDB.model.Creature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CreatureController {

    // Autowired - when run, finds and creates an instance of the class by inversion of control
    @Autowired
    private CreatureDao creatureDao;

    @GetMapping("/creature/get-all")
    public List<Creature> getAllCreatures() {
        return creatureDao.getAllCreatures();
    }

//    @GetMapping("/creature/get-by-party-id/{id}")
//    public List<Creature> getByPartyId(@PathVariable int id) {
//        return creatureDao.getCreatureByPartyId(id);
//    }

    @PostMapping("/creature/save")
    public Creature saveCreature(@RequestBody Creature creature) {
        return creatureDao.saveCreature(creature);
    }
}
