package com.ooadproject.projectmonDB.controller;

import com.ooadproject.projectmonDB.dao.CreatureDao;
import com.ooadproject.projectmonDB.model.party.Creature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CreatureController {

    @Autowired
    private CreatureDao CreatureDao;

    @GetMapping("/creature/get-all")
    public List<Creature> getAllCreatures() {
        return CreatureDao.getAllCreatues();
    }

    @PostMapping("/creature/save")
    public Creature saveCreature(@RequestBody Creature creature) {
        return CreatureDao.saveCreature(creature);
    }
}
