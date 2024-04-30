package com.ooadproject.projectmonDB.dao;

import org.example.NetworkMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

// DAO - Data Access Object: abstracts and encapsulates all access to the datasource


@Service
public class MatchDao {

    @Async("threadPoolTaskExecutor")
    public void asyncMethodWithConfiguredExecutor() {
        System.out.println("Execute method with configured executor - "
                + Thread.currentThread().getName());
    }
    public Future<String> findMatch(NetworkMessage message) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Simulating a time-consuming computation
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "owo"; // The result of the computation
        });
        return future;

    }


}

