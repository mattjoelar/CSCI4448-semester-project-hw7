package com.ooadproject.projectmonDB.model.party;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// CrudRepositiory - allows automatic functionality to save
// @Repository - allows you to use actions (save, delete, ect.)
@Repository
public interface CreatureRepository extends CrudRepository<Creature, Integer> {

}
