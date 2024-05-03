package com.ooadproject.projectmonDB.model;

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
    private String name;

    @NotNull
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY , orphanRemoval = true)
    @JoinColumn(name = "fk_party_id", referencedColumnName = "party_id")
//    @JsonIgnore
    @JsonManagedReference
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
    public String getName() {
        return name;
    }

    public void setName(@NotNull String partyName) {
        this.name = partyName;
    }

    public int getParty_id() {
        return party_id;
    }

    public void setParty_id(int party_id) {
        this.party_id = party_id;
    }


//---------------- To String ----------------//


    @Override
    public String toString() {
        return "Party{" +
                "party_id=" + party_id +
                ", name='" + name + '\'' +
                ", creatures=" + creatures +
                '}';
    }
}