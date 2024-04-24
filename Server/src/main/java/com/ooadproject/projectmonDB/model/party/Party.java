package com.ooadproject.projectmonDB.model.party;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Entity
@Table(name="party")
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int party_id;

    @NotNull
    private String partyName;


    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_party_id", referencedColumnName = "party_id")
    private List<Creature> monID;

//    @NotNull
//    private int mon2;
//
//    @NotNull
//    private int mon3;
//
//    @NotNull
//    private int mon4;
//
//    @NotNull
//    private int mon5;
//
//    @NotNull
//    private int mon6;
//
//    public int getMon6() {
//        return mon6;
//    }
//
//    public void setMon6(int mon6) {
//        this.mon6 = mon6;
//    }
//
//    public int getMon5() {
//        return mon5;
//    }
//
//    public void setMon5(int mon5) {
//        this.mon5 = mon5;
//    }
//
//    public int getMon4() {
//        return mon4;
//    }
//
//    public void setMon4(int mon4) {
//        this.mon4 = mon4;
//    }
//
//    public int getMon3() {
//        return mon3;
//    }
//
//    public void setMon3(int mon3) {
//        this.mon3 = mon3;
//    }
//
//    public int getMon2() {
//        return mon2;
//    }
//
//    public void setMon2(int mon2) {
//        this.mon2 = mon2;
//    }

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

    @Override
    public String toString() {
        return "Party{" +
                "party_id=" + party_id +
                ", name='" + partyName + '\'' +
                ", monID=" + monID +
//                ", mon2=" + mon2 +
//                ", mon3=" + mon3 +
//                ", mon4=" + mon4 +
//                ", mon5=" + mon5 +
//                ", mon6=" + mon6 +
                '}';
    }
}
