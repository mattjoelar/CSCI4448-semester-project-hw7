package com.ooadproject.projectmonDB.repository;

import com.ooadproject.projectmonDB.model.Move;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// CrudRepositiory - allows automatic functionality to save
// @Repository - allows you to use actions (save, delete, ect.)
@Repository
public interface MoveRepository extends JpaRepository<Move, Integer> {

}