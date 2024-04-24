package com.ooadproject.projectmonDB.controller;

import com.ooadproject.projectmonDB.model.party.Creature;
import com.ooadproject.projectmonDB.model.party.DBDao;
import com.ooadproject.projectmonDB.model.party.Party;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Allows SpringBoot to automatically control get/post
@RestController
public class WebController {

    @Autowired
    private DBDao DBDao;

    //Gets all creatures from DB server
    @GetMapping("/party/get-all")
    public List<Party> getAllCreatures() {
        return DBDao.getAllParties();
    }

    //Posts to DB server
    @PostMapping("/party/save")
    public Party save(@RequestBody Party party) {
        return DBDao.save(party);
    }
}
