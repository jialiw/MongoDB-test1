package com.gv.mongodb.Test1.services;

import java.util.List;
import java.util.Optional;

import com.gv.mongodb.Test1.models.TestModel;

public interface TestModelService {

	List<TestModel> getAllModels(Integer limit);

	List<TestModel> getModelByNaccId(String naccid);
	
	List<TestModel> getModelByVisitDay(String day);
	
	List<TestModel> getModelByVisitYear(String year);
	
	List<TestModel> getModelByMultiPara(String naccid, String day, String year);

	TestModel addModel(TestModel tm);

//	TestModel updateModel(TestModel tm);

	boolean deleteModel(String pid);

}
