package com.pokedex.backend.dao;

import com.mongodb.client.result.DeleteResult;
import io.swagger.model.Move;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexOperations;
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
        IndexOperations indexOperations = mongoTemplate.indexOps("Move");
        Index index = new Index().on("name", Sort.Direction.ASC).unique();
        indexOperations.createIndex(index);
    }

    public DeleteResult deleteMove(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.remove(query, Move.class, "Move");
    }

    public Move modifyMove(String name, Move move) {
        Query query = new Query(Criteria.where("name").is(name));
        mongoTemplate.remove(query, Move.class, "Move");
        return mongoTemplate.insert(move, "Move");
    }

    public Move getMove(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, Move.class, "Move");
    }
}
