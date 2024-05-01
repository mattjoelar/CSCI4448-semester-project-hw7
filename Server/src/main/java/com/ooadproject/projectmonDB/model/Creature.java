package com.ooadproject.projectmonDB.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;


@Entity
@Table(name="creature")
public class Creature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "identifier", nullable = false)
    private int identifier;

    @Column(name = "level", nullable = false)
    private int level;

    @Column(name = "xp", nullable = false)
    private int xp;

    @Column(name = "xp_max", nullable = false)
    private int xp_max;

    @Column(name = "hp", nullable = false)
    private float hp;

    @Column(name = "attack", nullable = false)
    private float attack;

    @Column(name = "defense", nullable = false)
    private float defense;

    @Column(name = "speed", nullable = false)
    private float speed;

    @Column(name = "moves", nullable = false)
    private int moves;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_party_id")
    @JsonBackReference
    private Party party;

//-------------- Getters & Setters --------------//

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getMoves() {
        return moves;
    }

    public void setMoves(int movesID) {
        this.moves = movesID;
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

    public int getXp_max() {
        return xp_max;
    }

    public void setXp_max(int pxMax) {
        this.xp_max = pxMax;
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


    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier( int identifier) {
        this.identifier = identifier;
    }

//---------------- To String ----------------//


//    @Override
//    public String toString() {
//        return "Creature{" +
//                "id=" + id +
//                ", identifier=" + identifier +
//                ", level=" + level +
//                ", xp=" + xp +
//                ", xp_max=" + xp_max +
//                ", hp=" + hp +
//                ", attack=" + attack +
//                ", defense=" + defense +
//                ", speed=" + speed +
//                ", moves=" + moves +
//                ", party=" + party +
//                '}';
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Creature{ id=").append(id).append(", ");
        sb.append("identifier=").append(identifier).append(", ");
        sb.append("level=").append(level).append(", ");
        sb.append("xp=").append(xp).append(", ");
        sb.append("xpMax=").append(xp_max).append(", ");
        sb.append("hp=").append(hp).append(", ");
        sb.append("attack=").append(attack).append(", ");
        sb.append("defense=").append(defense).append(", ");
        sb.append("speed=").append(speed).append(", ");
        sb.append("moves=").append(moves).append(", ");
        sb.append("party=").append(partyToString());
        sb.append("}");
        return sb.toString();
    }

    private String partyToString() {
        if(party == null){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("Party{" + "party_id=").append(party.getParty_id());
        sb.append(", party_name='").append(party.getName()).append('\'');
        sb.append('}');

        sb.delete(sb.length()-2, sb.length()); // Remove the last ", "
        sb.append("]");
        return sb.toString();
    }
}
