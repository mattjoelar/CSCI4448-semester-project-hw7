package com.ooadproject.projectmonDB.controller;

import com.ooadproject.projectmonDB.dao.MatchDao;
import org.example.NetworkMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
public class ServerAPIController {

    // Autowired - when run, finds and creates an instance of the class by inversion of control

    @Autowired
    private ServerAPI ServerAPI;

    @GetMapping("/match/find")
    public Map<?, ?> findMatch(@RequestBody NetworkMessage message) throws ExecutionException, InterruptedException {
        return ServerAPI.findMatch(message).get().asMap();
    }
    //Called 1 time, player waits until another player class it, then both functions return "Start Match" as a Kotlin Map

}
