package com.gv.mongodb.Test1.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.gv.mongodb.Test1.models.TestModel;
import com.mongodb.client.result.DeleteResult;

public class TestModelRepositoryCustomImpl implements TestModelRepositoryCustom{
	
	private final MongoTemplate mongoTemplate;
	
	@Autowired
	public TestModelRepositoryCustomImpl (MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public List<TestModel> findAllByNaccId(String naccid) {
		final Query query = new Query();
		query.addCriteria(Criteria.where("NACCID").is(naccid));
//		query.fields().include("VISITDAY").include("VISITYR").include("NACCID");
		
//		List<TestModel> r = mongoTemplate.find(query, TestModel.class);
//		System.out.println("check result: " + r);
		return mongoTemplate.find(query, TestModel.class);
	}

	@Override
	public List<TestModel> findAllByYear(String year) {
		final Query query = new Query();
		query.addCriteria(Criteria.where("VISITYR").is(year));		
		return mongoTemplate.find(query, TestModel.class);
	}

	@Override
	public List<TestModel> findAllByDay(String day) {
		final Query query = new Query();
		query.addCriteria(Criteria.where("VISITDAY").is(day));
		return mongoTemplate.find(query, TestModel.class);
	}

	@Override
	public List<TestModel> listAllRecords(Integer limit) {
		final Query query = new Query();
		query.limit(limit);
		query.with(new Sort(Sort.Direction.ASC, "NACCID"));
		return mongoTemplate.find(query, TestModel.class);
	}

	@Override
	public TestModel addTestModel(TestModel tm) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean deleteTestModel(String naccid) {
		final Query query = new Query();
		query.addCriteria(Criteria.where("NACCID").is(naccid));
		DeleteResult dResult = mongoTemplate.remove(query, TestModel.class);
		if (dResult.wasAcknowledged()) {
			return true;
		} else {
			return false;
		}
	}

	
}
