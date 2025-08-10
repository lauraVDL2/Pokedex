package com.pokedex.backend.dao;

import io.swagger.model.Move;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MoveDao extends AbstractDao<Move> {

    public List<Move> searchMoves(List<String> names) {
        Criteria criteria = Criteria.where("name").in(names);
        Query query = new Query(criteria);
        return mongoTemplate.find(query, Move.class, "Move");
    }

    @Override
    public void createIndexes() {

    }
}
