package com.ooadproject.projectmonDB.controller;

import com.ooadproject.projectmonDB.dao.PartyDao;
import com.ooadproject.projectmonDB.model.Party;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Allows SpringBoot to automatically control get/post
@RestController
public class PartyController {

    @Autowired
    private PartyDao partyDao;

    //Gets all creatures from DB server
    @GetMapping("/party/get-all")
    public List<Party> getAllParties() {
        return partyDao.getAllParties();
    }

    @GetMapping("/party/get-party/{id}")
    public Party getPartyById(@PathVariable int id) {
        return partyDao.getPartyById(id);
    }

    //Posts to DB server
    @PostMapping("/party/save")
    public Party saveParty(@RequestBody Party party) {
        return partyDao.saveParty(party);
    }
}
