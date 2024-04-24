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
    private String name;

    @NotNull
    private int level;

    @NotNull
    private int xp;

    @NotNull
    private int xpMax;

    @NotNull
    private int hp;

    @NotNull
    private int attack;

    @NotNull
    private int defense;

    @NotNull
    private int speed;

    @NotNull
    private int movesID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_party_id")
    private Party party;

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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
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
    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", xp=" + xp +
                ", xpMax=" + xpMax +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defense=" + defense +
                ", speed=" + speed +
                ", movesID=" + movesID +
                '}';
    }
}
