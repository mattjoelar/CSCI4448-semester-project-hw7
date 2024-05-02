package com.ooadproject.projectmonDB.dao;

import com.ooadproject.projectmonDB.model.Move;
import com.ooadproject.projectmonDB.model.Party;
import com.ooadproject.projectmonDB.repository.MoveRepository;
import com.ooadproject.projectmonDB.repository.PartyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// DAO - Data Access Object: abstracts and encapsulates all access to the datasource
@Service
@Transactional
public class MoveDao {
    // Using Repository implements dependency injection
    @Autowired
    private MoveRepository repository;

    public Move saveMove(Move move) {
    return repository.save(move);
    }

    // Returns an Iterable by default
    public List<Move> getAllMoves() {
        List<Move> moves = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(moves::add );

        return moves;
    }
}