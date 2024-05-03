package com.ooadproject.projectmonDB.dao;

import com.ooadproject.projectmonDB.model.Creature;
import com.ooadproject.projectmonDB.repository.CreatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// DAO - Data Access Object: abstracts and encapsulates all access to the datasource
@Service
public class CreatureDao {
    @Autowired
    private CreatureRepository repository;
    public Creature saveCreature(Creature creature) { return repository.save(creature); }


    public List<Creature> getAllCreatures() {
        List<Creature> creatures = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(creatures::add);
        return creatures;
    }


    public Creature getCreatureById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteCreature(Creature creature) { repository.delete(creature); }

    public void deleteCreatureById(int id) { repository.deleteById(id); }



}