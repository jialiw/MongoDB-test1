package com.gv.mongodb.Test1.models;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class TestModel implements Serializable {

	@Id
	public String pid;

	public String name;
	public Date date;

	public TestModel() {
	}

	public TestModel(String pid, String name, Date date) {
		this.name = name;
		this.pid = pid;
		this.date = date;
	}

	@Override
	public String toString() {
		return "TestModel{" + "id=" + this.pid + ", name='" + this.name + "', date=" + this.date.toString() + "}";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || this.getClass() != o.getClass())
			return false;

		TestModel tm = (TestModel) o;

		if (this.name != tm.name)
			return false;
		if (this.pid != null ? !this.pid.equals(tm.pid) : tm.pid != null)
			return false;
		if (this.name != null ? !this.name.equals(tm.name) : tm.name != null)
			return false;
		return this.date != null ? !this.date.equals(tm.date) : tm.date != null;
	}

	@Override
	public int hashCode() {
		int result = this.pid != null ? this.pid.hashCode() : 0;
		result = 31 * result + (this.name != null ? this.name.hashCode() : 0);
		result = 31 * result + (this.date != null ? this.date.hashCode() : 0);
		return result;
	}
}
