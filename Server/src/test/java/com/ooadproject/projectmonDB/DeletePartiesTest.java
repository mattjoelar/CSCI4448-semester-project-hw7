package com.ooadproject.projectmonDB;

import com.ooadproject.projectmonDB.dao.CreatureDao;
import com.ooadproject.projectmonDB.dao.MoveDao;
import com.ooadproject.projectmonDB.dao.PartyDao;
import com.ooadproject.projectmonDB.model.Party;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DeletePartiesTest {

    @Autowired
    private PartyDao partyDao;
    @Autowired
    private CreatureDao creatureDao;
    @Autowired
    private MoveDao moveDao;


    @Test
    void deleteAllParties() {
        List<Party> parties = partyDao.getAllParties();
        for(Party party : parties) {
            partyDao.deleteParty(party);
        }
        int numParties = partyDao.getAllParties().size();
        int numCreatures = creatureDao.getAllCreatures().size();
        int numMoves = moveDao.getAllMoves().size();

        assertEquals(0, numParties);
        assertEquals(0, numCreatures);
        assertEquals(0,numMoves);
    }

}