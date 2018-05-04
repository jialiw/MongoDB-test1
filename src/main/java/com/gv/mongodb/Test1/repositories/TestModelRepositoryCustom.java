package com.gv.mongodb.Test1.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gv.mongodb.Test1.models.TestModel;

@Repository // Repository are the DAOs (Data Access Objects), they access the database
			// directly.
public interface TestModelRepositoryCustom {
	
	List<TestModel>listAllRecords(Integer limit);
	
	List<TestModel>findAllByNaccId(String naccid);
	
	List<TestModel>findAllByYear(String year);
	
	List<TestModel>findAllByDay(String day);
	
	List<TestModel>findAllByMultiPara (String naccid, String year, String day);
	
	TestModel addTestModel(TestModel tm);
	
	boolean deleteTestModel(String naccid);
}
