package com.ooadproject.projectmonDB;

import com.ooadproject.projectmonDB.model.Creature;
import com.ooadproject.projectmonDB.dao.PartyDao;
import com.ooadproject.projectmonDB.model.Move;
import com.ooadproject.projectmonDB.model.Party;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AddPartiesTest {

    @Autowired
    private PartyDao partyDao;

    @Test
    void addPartiesTest() {

        Move move1 = new Move();
        move1.setIdentifier(1);
        Move move2 = new Move();
        move2.setIdentifier(2);
        Move move3 = new Move();
        move3.setIdentifier(3);
        Move move4 = new Move();
        move4.setIdentifier(4);

        List<Move> movesList1 = List.of(move1, move2, move3,move4);
        List<Move> movesList2 = List.of(move2, move4, move2, move3);

        Creature creature1 = new Creature();
        creature1.setIdentifier(1);
        creature1.setLevel(1);
        creature1.setXp(20);
        creature1.setXp_max(100);
        creature1.setHp(100);
        creature1.setAttack(20);
        creature1.setDefense(20);
        creature1.setSpeed(50);
        creature1.setMoves(movesList1);

        Creature creature2 = new Creature();
        creature2.setIdentifier(1);
        creature2.setLevel(2);
        creature2.setXp(50);
        creature2.setXp_max(300);
        creature2.setHp(150);
        creature2.setAttack(30);
        creature2.setDefense(30);
        creature2.setSpeed(55);
        creature2.setMoves(movesList2);

        List<Creature> monList = List.of(creature1, creature2);

        Party party = new Party();
        party.setName("Mike");
        party.setCreatures(monList);

        partyDao.saveParty(party);
    }

}