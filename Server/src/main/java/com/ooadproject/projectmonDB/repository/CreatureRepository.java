package com.ooadproject.projectmonDB.repository;

import com.ooadproject.projectmonDB.model.party.Creature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatureRepository extends CrudRepository<Creature, Integer> {
}
