package com.gv.mongodb.Test1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gv.mongodb.Test1.models.TestModel;
import com.gv.mongodb.Test1.services.TestModelService;

@RestController
public class TestModelController {

	@Autowired
	private TestModelService testModelService;

	@ResponseBody
	@RequestMapping(value = "/models", method = RequestMethod.GET)
	public List<TestModel> getAllModels() {
		return testModelService.getAllModels();
	}

	@ResponseBody
	@RequestMapping(value = "/model/{pid}", method = RequestMethod.GET)
	public TestModel getModelById(@PathVariable String pid) {
		return testModelService.getModelById(pid);
	}

	@ResponseBody
	@RequestMapping(value = "/models", method = RequestMethod.POST)
	public TestModel addTestModel(@RequestBody TestModel testModel) {
		return testModelService.addModel(testModel);
	}

	@ResponseBody
	@RequestMapping(value = "/models", method = RequestMethod.PUT)
	public TestModel updateTestModel(@RequestBody TestModel testModel) {
		return testModelService.updateModel(testModel);
	}

	@ResponseBody
	@RequestMapping(value = "/model/{pid}, method =  RequestMethod.DELETE")
	public String deleteTestModel(@PathVariable String pid) {
		testModelService.deleteModel(pid);
		return "Deleted";
	}
}
