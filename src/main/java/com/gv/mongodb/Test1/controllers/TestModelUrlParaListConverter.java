package com.gv.mongodb.Test1.controllers;

import java.util.LinkedList;
import java.util.List;

public class TestModelUrlParaListConverter {
	public <T> List<T> ConvertSingleParaToList(T para) {
		List<T> maskList = new LinkedList<T>();
		maskList.add(para);
		return maskList;
		
	}
}
