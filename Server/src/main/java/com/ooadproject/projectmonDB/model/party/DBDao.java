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
    private DBRepository repository;
    public Party save(Party party) { return repository.save(party); }


    // Returns an Iterable by default
    public List<Party> getAllParties() {
        List<Party> parties = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(parties::add );
        return parties;
    }

    // Delete by creature
    public void delete(Party party) { repository.delete(party); }

    // To delete by ID
    public void delete(int partyId){
        repository.deleteById(partyId);
    }
}
