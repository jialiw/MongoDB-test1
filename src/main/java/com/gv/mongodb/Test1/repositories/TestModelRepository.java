package com.gv.mongodb.Test1.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gv.mongodb.Test1.models.TestModel;

@Repository 
public interface TestModelRepository extends MongoRepository<TestModel, String>, TestModelRepositoryCustom{

}
