package com.ooadproject.projectmonDB;

import com.ooadproject.projectmonDB.model.Creature;
import com.ooadproject.projectmonDB.dao.PartyDao;
import com.ooadproject.projectmonDB.model.Party;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AddPartiesTest {

    @Autowired
    private PartyDao partyDao;

    @Test
    void addPartiesTest() {

        Creature creature1 = new Creature();
        creature1.setIdentifier(1);
        creature1.setLevel(1);
        creature1.setXp(20);
        creature1.setXp_max(100);
        creature1.setHp(100);
        creature1.setAttack(20);
        creature1.setDefense(20);
        creature1.setSpeed(50);
        creature1.setMoves(200);

        Creature creature2 = new Creature();
        creature2.setIdentifier(1);
        creature2.setLevel(2);
        creature2.setXp(50);
        creature2.setXp_max(300);
        creature2.setHp(150);
        creature2.setAttack(30);
        creature2.setDefense(30);
        creature2.setSpeed(55);
        creature2.setMoves(300);

        List<Creature> monList = List.of(creature1, creature2);

        Party party = new Party();
        party.setParty_name("Mike");
        party.setCreatures(monList);

        partyDao.saveParty(party);
    }

}