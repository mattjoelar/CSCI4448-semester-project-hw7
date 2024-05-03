package com.ooadproject.projectmonDB;

import com.ooadproject.projectmonDB.dao.ServerAPI;
import org.example.NetworkMessage;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class matchMakerP2Test {

    @Test
    void matchMakerPlayerTWOConnects() throws ExecutionException, InterruptedException {
        ServerAPI serverAPI = new ServerAPI();


        CompletableFuture<NetworkMessage> p1 = serverAPI.findMatch();



        CompletableFuture<NetworkMessage> p2 = serverAPI.findMatch();

        //waits for both players
        CompletableFuture.allOf(p1, p2).join();

        assert ((Objects.equals(p1.get().asMap(), p2.get().asMap())));

    }
}
