package com.ooadproject.projectmonDB.controller;

import com.ooadproject.projectmonDB.dao.CreatureDao;
import com.ooadproject.projectmonDB.dao.MatchDao;
import com.ooadproject.projectmonDB.model.Creature;
import org.example.NetworkMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MatchController {

    // Autowired - when run, finds and creates an instance of the class by inversion of control
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") //suppresses Autowired warning cuz Lord Stack Demands it
    @Autowired
    private MatchDao matchDao;

    @GetMapping("/match/find")
    public String findMatch(@RequestBody NetworkMessage message) throws ExecutionException, InterruptedException {
        return matchDao.findMatch(message).get();
    }


}
