package com.pokedex.backend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public abstract class AbstractDao<T> {

    @Autowired
    MongoTemplate mongoTemplate;

    public abstract void createIndexes();

    public T createEntity(T entity, String collectionName) {
        this.createIndexes();
        return mongoTemplate.save(entity, collectionName);
    }
}
