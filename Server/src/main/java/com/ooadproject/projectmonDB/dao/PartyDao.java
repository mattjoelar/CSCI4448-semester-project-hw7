package com.ooadproject.projectmonDB.dao;


import com.ooadproject.projectmonDB.model.Creature;
import com.ooadproject.projectmonDB.model.Move;
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
        if (parties.isEmpty()) {
            System.out.println("\"No Parties\"");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(" [ {").append("\n");
            for (Party party : parties) {

                sb.append("\t[ Party{ party_id= ").append(party.getParty_id()).append(", ").append("\n");
                sb.append("\t party_name ").append(party.getName()).append("\n");
                sb.append("\t creatures= ");
                sb.append("[ {").append("\n");

                for (Creature creature : party.getCreatures()) {
                    sb.append("\t\t creature_identifier= ").append(creature.getIdentifier()).append(", ").append("\n");
                    sb.append("\t\t level= ").append(creature.getLevel()).append(", ").append("\n");
                    sb.append("\t\t xp= ").append(creature.getXp()).append(", ").append("\n");
                    sb.append("\t\t xpMax= ").append(creature.getXp_max()).append(", ").append("\n");
                    sb.append("\t\t hp= ").append(creature.getHp()).append(", ").append("\n");
                    sb.append("\t\t attack= ").append(creature.getAttack()).append(", ").append("\n");
                    sb.append("\t\t defense= ").append(creature.getDefense()).append(", ").append("\n");
                    sb.append("\t\t speed= ").append(creature.getSpeed()).append(", ").append("\n");
                    sb.append("\t\t moves= ");

                    sb.append("[ { ").append("\n");
                    for (Move move : creature.getMoves()) {
                        sb.append("\t\t\t move_identifier= ").append(move.getIdentifier());
                        sb.append(", ").append("\n");
                    }
                    sb.delete(sb.length() - 2, sb.length()).append("\n");
                    sb.append("\t\t } ], \n");

                }
                sb.delete(sb.length() - 2, sb.length());
                sb.append("\t } ], \n");

            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append(" } ]");
            System.out.println(sb.toString());

        }
    }

    public Party getPartyByName (String name){
        return repository.findByName(name);
    }


    public Party getPartyById ( int id){
        return repository.findById(id).orElse(null);
    }

    // Delete by creature
    public void deleteParty (Party party){
        repository.delete(party);
    }

    // To delete by ID
    public void deletePartyByID ( int partyId){
        repository.deleteById(partyId);
    }

}
