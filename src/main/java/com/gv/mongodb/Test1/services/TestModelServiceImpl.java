package com.gv.mongodb.Test1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gv.mongodb.Test1.models.TestModel;
import com.gv.mongodb.Test1.repositories.TestModelRepository;

@Service // hold business logic and call method in repository layer
public class TestModelServiceImpl implements TestModelService {

	final static Integer DEFAULT_LIMIT = 10;
	
	@Autowired
	private TestModelRepository testModelRepository;

	@Override
	public List<TestModel> getAllModels(Integer limit) {
		if (limit == null || limit <= 0) {
			return testModelRepository.listAllRecords(DEFAULT_LIMIT);
		} else {
			return testModelRepository.listAllRecords(limit);
		}
	}

	@Override
	public List<TestModel> getModelByNaccId(String naccid) {
		return testModelRepository.findAllByNaccId(naccid);
	}

	@Override
	public TestModel addModel(TestModel tm) {
		return testModelRepository.addTestModel(tm);
	}

	@Override
	public List<TestModel> getModelByVisitDay(String day) {
		return testModelRepository.findAllByDay(day);
	}

	@Override
	public List<TestModel> getModelByVisitYear(String year) {
		return testModelRepository.findAllByYear(year);
	}

//	@Override
//	public TestModel updateModel(TestModel tm) {
//		return testModelRepository.save(tm);
//	}
//
	@Override
	public boolean deleteModel(String naccid) {
		return testModelRepository.deleteTestModel(naccid);
	}
}
