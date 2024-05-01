package com.ooadproject.projectmonDB.repository;

import com.ooadproject.projectmonDB.model.Creature;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreatureRepository extends JpaRepository<Creature, Integer> {
    // Find Creatures with Party foreign key == party_id
//    @Query("select * from Creature where c.partyfk =?1")
//    List<Creature> findByPartyfk(int partyfk);


}
