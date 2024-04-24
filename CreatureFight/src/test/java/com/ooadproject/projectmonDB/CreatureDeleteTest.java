package com.ooadproject.projectmonDB;

import com.ooadproject.projectmonDB.model.party.Creature;
import com.ooadproject.projectmonDB.model.party.DBDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CreatureDeleteTest {

    @Autowired
    private DBDao dbDao;


    @Test
    void deleteAllCreatures() {
        List<Creature> creatures = dbDao.getAllEmployees();
        for(Creature creature : creatures){
            dbDao.delete(creature);
        }
        // assert creatures.size == 0
    }
}
