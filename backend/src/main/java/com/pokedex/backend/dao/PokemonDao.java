package com.pokedex.backend.dao;

import com.mongodb.client.result.DeleteResult;
import io.swagger.model.Pokemon;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * Get all Pokemon with pagination and sorting by entry number
     * @param offset
     * @param limit
     * @param collectionName
     * @param entityClass
     * @return
     */
    @Override
    public List<Pokemon> getAllEntityWithPagination(Integer offset, Integer limit, String collectionName, Class<Pokemon> entityClass) {
        Query query = new Query();
        // Calculate skip
        int skip = (offset - 1) * limit;
        query.skip(skip);
        query.limit(limit);
        // Add ascending sort by 'entryNumber'
        query.with(Sort.by(Sort.Direction.ASC, "entryNumber"));
        return mongoTemplate.find(query, entityClass, collectionName);
    }

    public Pokemon getPokemon(Integer entryNumber) {
        Query query = new Query();
        query.addCriteria(Criteria.where("entryNumber").is(entryNumber));
        return mongoTemplate.findOne(query, Pokemon.class, "Pokemon");
    }

}
