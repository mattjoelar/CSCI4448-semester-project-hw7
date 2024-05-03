package com.ooadproject.projectmonDB;

import com.ooadproject.projectmonDB.dao.MatchDao;
import org.example.NetworkMessage;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class matchMakerP2Test {

    @Test
    void matchMakerPlayerTWOConnects() throws ExecutionException, InterruptedException {
        ServerAPI serverAPI= new ServerAPI();
        NetworkMessage message = new NetworkMessage("I wanna fight");

        CompletableFuture<NetworkMessage> p1 = ServerAPI.findMatch(message);

        NetworkMessage message2 = new NetworkMessage("I wanna fight as well");

        CompletableFuture<NetworkMessage> p1 = ServerAPI.findMatch(message);

        //waits for both players
        CompletableFuture.allOf(p1, p2).join();

        assert ((Objects.equals(p1.get().asMap(), p2.get().asMap())));

    }
}
