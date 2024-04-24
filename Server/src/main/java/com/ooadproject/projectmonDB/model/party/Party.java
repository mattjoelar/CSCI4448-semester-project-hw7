package com.ooadproject.projectmonDB.model.party;

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
    private String partyName;

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fk_party_id", referencedColumnName = "party_id")
    private List<Creature> monID = new ArrayList<Creature>();
//-------------- Getters & Setters --------------//


    public List<Creature> getMonID() {
        return monID;
    }

    public void setMonID(List<Creature> monID) {
        this.monID = monID;
    }

    @NotNull
    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(@NotNull String partyName) {
        this.partyName = partyName;
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
                ", partyName='" + partyName + '\'' +
                ", monID=" + monID +
                '}';
    }
}
