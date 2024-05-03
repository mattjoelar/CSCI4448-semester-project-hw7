package com.ooadproject.projectmonDB.repository;

import com.ooadproject.projectmonDB.model.Creature;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreatureRepository extends JpaRepository<Creature, Integer> {

//    List<Creature> findByPartyContaining(int fk_party_id);

}
