package com.ooadproject.creaturefight;

import com.ooadproject.creaturefight.model.creature.Creature;
import com.ooadproject.creaturefight.model.creature.CreatureDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CreatureDbTest {

	@Autowired
	private CreatureDao creatureDao; //change with Repository to delete by ID

	@Test
	void addCreatureTest() {
		Creature creature = new Creature();
		creature.setName("Pog Champ");
		creature.setHp(100);
		creature.setAttack(20);
		creature.setDefense(20);
		creature.setSpeed(50);
		creature.setMovesID(01);
		creatureDao.save(creature);
	}

	@Test
	void getAllCreatures() {
		List<Creature> creatures = creatureDao.getAllEmployees();
		System.out.println(creatures);
	}

	@Test
	void deleteCreature() {

	}

	@Test
	void deleteAllCreatures() {
		List<Creature> creatures = creatureDao.getAllEmployees();
		for(Creature creature : creatures){
			creatureDao.delete(creature);
		}
	}

}