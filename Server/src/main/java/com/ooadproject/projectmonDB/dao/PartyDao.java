package com.ooadproject.projectmonDB.dao;

import com.ooadproject.projectmonDB.model.party.Party;
import com.ooadproject.projectmonDB.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// DAO - Data Access Object: abstracts and encapsulates all access to the datasource
@Service
public class PartyDao {
    // Using Repository implements dependency injection
    @Autowired
    private PartyRepository repository;
    public Party saveParty(Party party) { return repository.save(party); }


    // Returns an Iterable by default
    public List<Party> getAllParties() {
        List<Party> parties = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(parties::add );
        return parties;
    }

    // Delete by creature
    public void deleteParty(Party party) { repository.delete(party); }

    // To delete by ID
    public void deletePartyByID(int partyId){
        repository.deleteById(partyId);
    }
}
