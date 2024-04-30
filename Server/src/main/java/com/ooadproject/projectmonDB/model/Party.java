package com.ooadproject.projectmonDB.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonManagedReference
    private List<Creature> creatures;

//-------------- Getters & Setters --------------//

    @NotNull
    public List<Creature> getCreatures() {
        return creatures;
    }

    public void setCreatures(@NotNull List<Creature> monID) {
        this.creatures = monID;
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


    @Override
    public String toString() {
        return "Party{" +
                "party_id=" + party_id +
                ", partyName='" + party_name + '\'' +
                ", monID=" + creatures +
                '}';
    }
}
