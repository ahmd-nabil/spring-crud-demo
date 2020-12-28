package com.nobel.springboot.cruddemo.service;

import java.util.List;

import com.nobel.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getAll();
	
	public Employee getById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
}
