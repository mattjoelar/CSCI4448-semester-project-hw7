package com.ooadproject.projectmonDB;

import com.ooadproject.projectmonDB.dao.PartyDao;
import com.ooadproject.projectmonDB.model.Party;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PrintPartiesTest {

    @Autowired
    private PartyDao partyDao;


    @Test
    void printAllParties() {
        partyDao.printAllParties();
    }


    //@Test
    void deleteCreature() {

    }

    //@Test
    void deleteAllParties() {
        List<Party> parties = partyDao.getAllParties();
        for(Party party : parties){
            partyDao.deleteParty(party);
        }
        assertNotNull(parties);
    }

}