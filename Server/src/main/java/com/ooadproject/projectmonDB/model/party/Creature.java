package com.ooadproject.projectmonDB.model.party;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;


@Entity
@Table(name="creature")
public class Creature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private int identifier;

    private int level;

    private int xp;

    private int xpMax;

    private float hp;

    private float attack;

    private float defense;

    private float speed;

    private int movesID;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_party_id")
    private Party party;

//-------------- Getters & Setters --------------//

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getMovesID() {
        return movesID;
    }

    public void setMovesID(int movesID) {
        this.movesID = movesID;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getDefense() {
        return defense;
    }

    public void setDefense(float defense) {
        this.defense = defense;
    }

    public float getAttack() {
        return attack;
    }

    public void setAttack(float attack) {
        this.attack = attack;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public int getXpMax() {
        return xpMax;
    }

    public void setXpMax(int pxMax) {
        this.xpMax = pxMax;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @NotNull
    public Party getParty() {
        return party;
    }

    public void setParty(@NotNull Party party) {
        this.party = party;
    }

    @NotNull
    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(@NotNull int identifier) {
        this.identifier = identifier;
    }

//---------------- To String ----------------//


    @Override
    public String toString() {
        return "Creature{" +
                "id=" + id +
                ", identifier=" + identifier +
                ", level=" + level +
                ", xp=" + xp +
                ", xpMax=" + xpMax +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defense=" + defense +
                ", speed=" + speed +
                ", movesID=" + movesID +
                ", party=" + party +
                '}';
    }
}
