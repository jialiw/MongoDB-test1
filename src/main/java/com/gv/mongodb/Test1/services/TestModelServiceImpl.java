package com.gv.mongodb.Test1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gv.mongodb.Test1.models.TestModel;
import com.gv.mongodb.Test1.repositories.TestModelRepository;

@Service // hold business logic and call method in repository layer
public class TestModelServiceImpl implements TestModelService {

	@Autowired
	private TestModelRepository testModelRepository;

	@Override
	public List<TestModel> getAllModels() {
		return testModelRepository.findAll();
	}

	@Override
	public TestModel getModelById(String pid) {
		return testModelRepository.findById(pid).orElse(new TestModel());
	}

	@Override
	public TestModel addModel(TestModel tm) {
		return testModelRepository.save(tm);
	}

	@Override
	public TestModel updateModel(TestModel tm) {
		return testModelRepository.save(tm);
	}

	@Override
	public void deleteModel(String pid) {
		testModelRepository.deleteById(pid);
	}
}
