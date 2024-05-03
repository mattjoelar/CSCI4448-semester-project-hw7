package com.ooadproject.projectmonDB;

import com.ooadproject.projectmonDB.dao.MatchDao;
import org.example.NetworkMessage;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.concurrent.ExecutionException;

public class matchmakerONETest {

    //Should wait forever or a long time until Player 2 connects, just sends a string I think
    //works when the loop is just an 'if' loop

    @Test
    void matchMakerPlayerOneConnects() throws ExecutionException, InterruptedException {
        MatchDao matchDao = new MatchDao();
        NetworkMessage message = new NetworkMessage("I wanna fight");

        matchDao.findMatch();

        assert (MatchDao.numOfPlayers == 1 );
    }
}
