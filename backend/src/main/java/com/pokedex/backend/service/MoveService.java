package com.pokedex.backend.service;

import com.mongodb.client.result.DeleteResult;
import com.pokedex.backend.dao.MoveDao;
import com.pokedex.backend.exceptionhandler.exceptions.UnauthorizedException;
import io.swagger.model.Move;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    public String deleteMove(String name) {
        DeleteResult deletion = moveDao.deleteMove(name);
        if (deletion.getDeletedCount() > 0) {
            return "Move " + name + " deleted successfully !";
        }
        else {
            return "Error deleting move " + name + ", are you sure it exists ?";
        }
    }

    public Move getMove(String name) {
        return moveDao.getMove(name);
    }

    public Move modifyMove(String name, Move move) {
        if (!StringUtils.pathEquals(name, move.getName())) {
            throw new UnauthorizedException("Cannot change name");
        }
        return moveDao.modifyMove(name, move);
    }

}
