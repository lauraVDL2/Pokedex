package com.pokedex.backend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public abstract class AbstractDao<T> {

    @Autowired
    MongoTemplate mongoTemplate;

    public abstract void createIndexes();

    public T createEntity(T entity, String collectionName) {
        this.createIndexes();
        return mongoTemplate.save(entity, collectionName);
    }

    public List<T> getAllEntityWithPagination(Integer offset, Integer limit, String collectionName, Class<T> entityClass) {
        Query query = new Query();
        // Calculate skip
        int skip = (offset - 1) * limit;
        query.skip(skip);
        query.limit(limit);
        // Add ascending sort by 'entryNumber'
        query.with(Sort.by(Sort.Direction.ASC, "entryNumber"));
        return mongoTemplate.find(query, entityClass, collectionName);
    }

}
