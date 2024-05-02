package com.ooadproject.projectmonDB.dao;

import org.example.NetworkMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


import java.util.concurrent.*;

import static java.sql.DriverManager.println;


// DAO - Data Access Object: abstracts and encapsulates all access to the datasource


@Service
public class MatchDao {

    public static int numOfPlayers = 0;
    SpringAsyncConfig ExecutorMaker = new SpringAsyncConfig();
    Executor exe = ExecutorMaker.getAsyncExecutor();


    @Async
    public CompletableFuture<String> findMatch(NetworkMessage message) throws ExecutionException, InterruptedException {
        numOfPlayers = numOfPlayers + 1;
        return CompletableFuture.supplyAsync(() -> {
            // Simulating waiting for another player to join
            println("Hello!");
            try {

                while (numOfPlayers < 2) {
                    Thread.sleep(1000);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Found Match!"; // The result of the computation
        }, exe);
    }
}




