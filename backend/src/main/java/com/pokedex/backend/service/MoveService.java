package com.pokedex.backend.service;

import com.pokedex.backend.dao.MoveDao;
import io.swagger.model.Move;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoveService {

    @Autowired
    MoveDao moveDao;

    public List<Move> searchMoves(List<String> moveNames) {
        if (!CollectionUtils.isEmpty(moveNames)) {
            return moveDao.searchMoves(moveNames);
        }
        return null;
    }

    public Move createMove(Move move) {
        return this.moveDao.createEntity(move, "Move");
    }
}
