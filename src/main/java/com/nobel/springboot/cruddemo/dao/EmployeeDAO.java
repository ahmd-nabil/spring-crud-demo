package com.nobel.springboot.cruddemo.dao;

import java.util.List;

import com.nobel.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> getAll();
	
	public Employee getById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
}
