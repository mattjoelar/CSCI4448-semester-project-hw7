package com.ooadproject.projectmonDB.controller;

import com.ooadproject.projectmonDB.dao.ServerAPI;
import org.example.NetworkMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
public class ServerAPIController {
    //may not need this entire class
    // Autowired - when run, finds and creates an instance of the class by inversion of control

    @Autowired
    private ServerAPI serverAPI;

    @GetMapping("/match/find")
    public Map<?, ?> findMatch(@RequestBody NetworkMessage message) throws ExecutionException, InterruptedException {
        return serverAPI.findMatch().get().asMap();
    }
    //Called 1 time, player waits until another player class it, then both functions return "Start Match" as a Kotlin Map

}
