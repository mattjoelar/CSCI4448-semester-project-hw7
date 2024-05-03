package com.ooadproject.projectmonDB.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="move")
public class Move {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "identifier", nullable = false)
    private int identifier;

    @NotNull
    @ManyToMany(mappedBy ="moves", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "fk_creature_id")
    @JsonBackReference
    private List<Creature> creatures = new ArrayList<>();

    //------------------------- Getters & Setters --------------------------//

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @NotNull
    public List<Creature> getCreatures() {
        return creatures;
    }
    @NotNull
    public void setCreatures(@NotNull List<Creature> creatures) {
        this.creatures = creatures;
    }

    //----------------------- To String -----------------------//

    @Override
    public String toString() {
        return "Move{" +
                "id=" + id +
                ", identifier=" + identifier +
                ", creatures=" + creatures +
                '}';
    }
}