package com.ooadproject.projectmonDB.dao;


import com.ooadproject.projectmonDB.model.Creature;
import com.ooadproject.projectmonDB.model.Party;
import com.ooadproject.projectmonDB.repository.PartyRepository;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;


import java.util.ArrayList;
import java.util.List;



// DAO - Data Access Object: abstracts and encapsulates all access to the datasource
@Service
@Transactional
public class PartyDao {
    // Using Repository implements dependency injection
    @Autowired
    private PartyRepository repository;

    public Party saveParty(Party party) {

//        Party party = repository.findById(party_id).orElseThrow(() -> new RuntimeException("Party not found"));
        return repository.save(party);
    }


    // Returns an Iterable by default
    public List<Party> getAllParties() {
        List<Party> parties = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(parties::add );

        return parties;
    }

    public void printAllParties() {
        List<Party> parties = repository.findAll();
        for(Party party : parties) {
            System.out.println(party);
//            System.out.println(party.getCreatures());
//            for(Creature creature : party.getCreatures()) {
//                System.out.println(creature.getXp_max());
//            }
        }
    }



    public Party getPartyById(int id) { return repository.findById(id).orElse(null); }

    // Delete by creature
    public void deleteParty(Party party) { repository.delete(party); }

    // To delete by ID
    public void deletePartyByID(int partyId){
        repository.deleteById(partyId);
    }
}
