package com.ooadproject.projectmonDB.dao;

import org.example.NetworkMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


import java.util.concurrent.*;

import static java.sql.DriverManager.println;


// DAO - Data Access Object: abstracts and encapsulates all access to the datasource


@Service
public class ServerAPI {

    private static ServerAPI instance;

    private ServerAPI(){}

    public static synchronized ServerAPI getInstance() {
        if (instance == null) {
            instance = new ServerAPI();
        }
        return instance;
    }

    public static int numOfPlayers = 0;
    SpringAsyncConfig ExecutorMaker = new SpringAsyncConfig();
    Executor exe = ExecutorMaker.getAsyncExecutor();


    @Async
    public CompletableFuture<NetworkMessage> findMatch(NetworkMessage message) throws ExecutionException, InterruptedException {
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
            return new NetworkMessage(
                    """
                            {
                            "Start Match"
                            }""");
                // JSON string in NetworkMessage, need to change back to map.
                //Text block seems useful
        }, exe);
    }
}




