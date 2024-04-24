package com.ooadproject.projectmonDB.model.party;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DBDao {
    // Using Repository implements dependency injection
    @Autowired
    private CreatureRepository repository;
    public Creature save(Creature creature) { return repository.save(creature); }

    // Returns an Iterable by default
    public List<Creature> getAllEmployees() {
        List<Creature> creatures = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(creatures::add );
        return creatures;
    }

    public void delete(Creature creature) { repository.delete(creature); }
//
//     To delete by ID
    public void delete(int creatureId){
        repository.deleteById(creatureId);
    }
}
