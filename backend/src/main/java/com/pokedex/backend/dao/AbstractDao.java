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

    /**
     * To be called by its child classes before inserting an element to the database
     */
    public abstract void createIndexes();

    public T createEntity(T entity, String collectionName) {
        this.createIndexes();
        return mongoTemplate.save(entity, collectionName);
    }

    /**
     * Generic get all with pagination without sorting
     * @param offset
     * @param limit
     * @param collectionName
     * @param entityClass
     * @return
     */
    public List<T> getAllEntityWithPagination(Integer offset, Integer limit, String collectionName, Class<T> entityClass) {
        Query query = new Query();
        // Calculate skip
        int skip = (offset - 1) * limit;
        query.skip(skip);
        query.limit(limit);
        return mongoTemplate.find(query, entityClass, collectionName);
    }

}
