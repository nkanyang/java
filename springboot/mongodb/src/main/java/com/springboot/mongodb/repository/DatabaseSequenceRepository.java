package com.springboot.mongodb.repository;

import com.springboot.mongodb.model.DatabaseSequence;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseSequenceRepository extends MongoRepository<DatabaseSequence, String> {
}
