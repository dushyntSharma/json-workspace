package com.mindtree.dao;

import java.util.List;

import com.mindtree.model.Employee;

public interface EntryDao {
	int setDatas(String name, int age, String skills);

	List<Employee> getValues();
}
