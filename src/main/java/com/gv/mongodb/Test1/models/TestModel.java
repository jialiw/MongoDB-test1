package com.gv.mongodb.Test1.models;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "NACC-test")
public class TestModel implements Serializable {
		
	@Field("NACCID")
	public String naccid;
	@Field("VISITYR")
	public String year;
	@Field("VISITDAY")
	public String date;

	public TestModel() {
	}

	public TestModel(String naccid, String date, String year) {
		this.naccid = naccid;
		this.date = date;
		this.year = year;
	}

	@Override
	public String toString() {
		return "TestModel{" + "id=" + this.naccid + ", year='" + this.year + "', date=" + this.date + "}";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || this.getClass() != o.getClass())
			return false;

		TestModel tm = (TestModel) o;

		if (this.naccid != tm.naccid)
			return false;
		if (this.year != null ? !this.year.equals(tm.year) : tm.year != null)
			return false;
//		if (this.date != null ? !this.date.equals(tm.date) : tm.date != null)
//			return false;
		return this.date != null ? !this.date.equals(tm.date) : tm.date != null;
	}

	@Override
	public int hashCode() {
		int result = this.naccid != null ? this.naccid.hashCode() : 0;
		result = 31 * result + (this.year != null ? this.year.hashCode() : 0);
		result = 31 * result + (this.date != null ? this.date.hashCode() : 0);
		return result;
	}
}
