package com.pokedex.backend.dao;

import com.mongodb.client.result.DeleteResult;
import io.swagger.model.Pokemon;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PokemonDao extends AbstractDao<Pokemon> {

    @Override
    public void createIndexes() {
        IndexOperations indexOperations = mongoTemplate.indexOps("Pokemon");
        Index index = new Index().on("entryNumber", Sort.Direction.ASC).unique();
        indexOperations.createIndex(index);
    }

    public DeleteResult deletePokemon(Integer entryNumber) {
        Query query = new Query();
        query.addCriteria(Criteria.where("entryNumber").is(entryNumber));
        return mongoTemplate.remove(query, Pokemon.class, "Pokemon");
    }

}
