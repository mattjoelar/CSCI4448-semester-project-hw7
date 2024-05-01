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
        MatchDao matchDao = new MatchDao();
        NetworkMessage message = new NetworkMessage("I wanna fight");

        CompletableFuture<String> p1 = matchDao.findMatch(message);

        NetworkMessage message2 = new NetworkMessage("I wanna fight as well");

        CompletableFuture<String> p2 = matchDao.findMatch(message2);

        //waits for both players
        CompletableFuture.allOf(p1, p2).join();

        assert ((Objects.equals(p1.get(), p2.get())));

    }
}
