package com.ooadproject.projectmonDB;

import com.ooadproject.projectmonDB.model.party.Creature;
import com.ooadproject.projectmonDB.model.party.DBDao;
import com.ooadproject.projectmonDB.model.party.Party;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProjectmonDbTest {

    @Autowired
    private DBDao dbDao;

    //@Test
    void addCreatureTest() {

        Creature creature = new Creature();
        creature.setName("Pog Champ");
        creature.setLevel(1);
        creature.setXp(20);
        creature.setXpMax(100);
        creature.setHp(100);
        creature.setAttack(20);
        creature.setDefense(20);
        creature.setSpeed(50);
        creature.setMovesID(200);

        List<Creature> monList = List.of(creature);

        Party party = new Party();
        party.setPartyName("Mike");
        party.setMonID(monList);

        dbDao.save(party);
    }

    @Test
    void getAllParties() {
        List<Party> parties = dbDao.getAllParties();
        System.out.println(parties);
        // assert creatures.size == 1;
    }

    //@Test
    void deleteCreature() {

    }

    //@Test
    void deleteAllParties() {
        List<Party> parties = dbDao.getAllParties();
        for(Party party : parties){
            dbDao.delete(party);
        }
        // assert creatures.size == 0
    }

}