package com.ooadproject.projectmonDB;

import com.ooadproject.projectmonDB.model.Creature;
import com.ooadproject.projectmonDB.dao.PartyDao;
import com.ooadproject.projectmonDB.model.Party;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.util.Streamable;

import java.util.List;

@SpringBootTest
class PrintPartiesTest {

    @Autowired
    private PartyDao partyDao;


    @Test
    void printAllParties() {
//        List<Party> parties = partyDao.getAllParties();
        partyDao.printAllParties();
//        parties.forEach(System.out::println);
//         assert creatures.size == 1;
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
        // assert creatures.size == 0
    }

}