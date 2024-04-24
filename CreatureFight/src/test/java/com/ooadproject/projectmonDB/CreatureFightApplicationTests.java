package com.ooadproject.projectmonDB;

import com.ooadproject.projectmonDB.model.party.Creature;
import com.ooadproject.projectmonDB.model.party.DBDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CreatureDbTest {

	@Autowired
	private DBDao dbDao;

	@Test
	void addCreatureTest() {
		Creature creature = new Creature();
		creature.setName("Pog Champ");
		creature.setHp(100);
		creature.setAttack(20);
		creature.setDefense(20);
		creature.setSpeed(50);
		creature.setMovesID(01);
		dbDao.save(creature);
	}

	@Test
	void getAllCreatures() {
		List<Creature> creatures = dbDao.getAllEmployees();
		System.out.println(creatures);
		// assert creatures.size == 1;
	}

	@Test
	void deleteCreature() {

	}

	@Test
	void deleteAllCreatures() {
		List<Creature> creatures = dbDao.getAllEmployees();
		for(Creature creature : creatures){
			dbDao.delete(creature);
		}
		// assert creatures.size == 0
	}

}