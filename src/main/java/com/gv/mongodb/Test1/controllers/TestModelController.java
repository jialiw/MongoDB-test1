package com.gv.mongodb.Test1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gv.mongodb.Test1.models.TestModel;
import com.gv.mongodb.Test1.services.TestModelService;

@RestController
public class TestModelController {

	@Autowired
	private TestModelService testModelService;

	// need to remodel later for regex searching and multi-para querying
	@ResponseBody
	@RequestMapping(value = "/models/", method = RequestMethod.GET)
	public ResponseEntity<List<TestModel>> getAllModels(@RequestParam(value="limit", required=false) Integer limit) {
		return new ResponseEntity<List<TestModel>>(testModelService.getAllModels(limit), HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/model/naccid/", method = RequestMethod.GET)
	public List<TestModel> getModelById(@RequestParam(value="naccid") String naccid) {
		return testModelService.getModelByNaccId(naccid);
	}
	
	@ResponseBody
	@RequestMapping(value = "/model/year/", method = RequestMethod.GET)
	public ResponseEntity<List<TestModel>> getModelByVisitYear(@RequestParam(value="year") String year) {
		return new ResponseEntity<List<TestModel>>(testModelService.getModelByVisitYear(year), HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/model/day/", method = RequestMethod.GET)
	public ResponseEntity<List<TestModel>> getModelByVisitDay(@RequestParam(value="day") String day) {
		return new ResponseEntity<List<TestModel>>(testModelService.getModelByVisitDay(day), HttpStatus.OK);
	}

//	@ResponseBody
//	@RequestMapping(value = "/models", method = RequestMethod.POST)
//	public TestModel addTestModel(@RequestBody TestModel testModel) {
//		return testModelService.addModel(testModel);
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/models", method = RequestMethod.PUT)
//	public TestModel updateTestModel(@RequestBody TestModel testModel) {
//		return testModelService.updateModel(testModel);
//	}
//
	@ResponseBody
	@RequestMapping(value = "/model/{naccid}", method =  RequestMethod.DELETE)
	public ResponseEntity<String> deleteTestModelByNaccid(@PathVariable String naccid) {
		boolean result = testModelService.deleteModel(naccid);
		if (result) {
			return new ResponseEntity<String>("Deleted records with naccid = " + naccid, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Fail to delete records with naccid = " + naccid, HttpStatus.CONFLICT);
		}
		
	}
}
