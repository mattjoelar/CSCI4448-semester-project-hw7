package com.ooadproject.projectmonDB.repository;

import com.ooadproject.projectmonDB.model.party.Party;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// CrudRepositiory - allows automatic functionality to save
// @Repository - allows you to use actions (save, delete, ect.)
@Repository
public interface PartyRepository extends CrudRepository<Party, Integer> {

}
