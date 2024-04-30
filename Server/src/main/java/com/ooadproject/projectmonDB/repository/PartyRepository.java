package com.ooadproject.projectmonDB.repository;

import com.ooadproject.projectmonDB.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// CrudRepositiory - allows automatic functionality to save
// @Repository - allows you to use actions (save, delete, ect.)
@Repository
public interface PartyRepository extends JpaRepository<Party, Integer> {

}
