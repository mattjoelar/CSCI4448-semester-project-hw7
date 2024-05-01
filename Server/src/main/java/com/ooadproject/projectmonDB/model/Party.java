package com.ooadproject.projectmonDB.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="party")
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int party_id;

    @NotNull
    @Column(name="party_name")
    private String party_name;

    @NotNull
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY , orphanRemoval = true)
    @JoinColumn(name = "fk_party_id", referencedColumnName = "party_id")
    @JsonIgnore
//    @JsonManagedReference
    private List<Creature> creatures = new ArrayList<>();

//-------------- Getters & Setters --------------//

    @NotNull
    public List<Creature> getCreatures() {
        return creatures;
    }

    public void setCreatures(@NotNull List<Creature> creature) {
        this.creatures = creature;
    }

    @NotNull
    public String getParty_name() {
        return party_name;
    }

    public void setParty_name(@NotNull String partyName) {
        this.party_name = partyName;
    }

    public int getParty_id() {
        return party_id;
    }

    public void setParty_id(int party_id) {
        this.party_id = party_id;
    }


//---------------- To String ----------------//


//    @Override
//    public String toString() {
//        return "Party{" +
//                "party_id=" + party_id +
//                ", party_name='" + party_name + '\'' +
//                ", creatures=" + creatures +
//                '}';
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Party{ party_id=").append(party_id);
        sb.append(", party_name='").append(party_name).append('\'');
        sb.append(", creatures=").append(creaturesToString());
        sb.append('}');
         return sb.toString();
    }

    private String creaturesToString() {
        if(creatures.isEmpty()){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Creature creature : creatures){
            sb.append("{ id=").append(creature.getId()).append(", ");
            sb.append("identifier=").append(creature.getIdentifier()).append(", ");
            sb.append("level=").append(creature.getLevel()).append(", ");
            sb.append("xp=").append(creature.getXp()).append(", ");
            sb.append("xpMax=").append(creature.getXp_max()).append(", ");
            sb.append("hp=").append(creature.getHp()).append(", ");
            sb.append("attack=").append(creature.getAttack()).append(", ");
            sb.append("defense=").append(creature.getDefense()).append(", ");
            sb.append("speed=").append(creature.getSpeed()).append(", ");
            sb.append("moves=").append(creature.getMoves()).append(" }");
            sb.append(", ");
        }
        sb.delete(sb.length()-2, sb.length()); // Remove the last ", "
        sb.append("]");
        return sb.toString();
    }

}
