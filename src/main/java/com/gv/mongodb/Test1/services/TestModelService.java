package com.gv.mongodb.Test1.services;

import java.util.List;

import com.gv.mongodb.Test1.models.TestModel;

public interface TestModelService {

	List<TestModel> getAllModels();

	TestModel getModelById(String pid);

	TestModel addModel(TestModel tm);

	TestModel updateModel(TestModel tm);

	void deleteModel(String pid);

}
