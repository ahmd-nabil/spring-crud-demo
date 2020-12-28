package com.nobel.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nobel.springboot.cruddemo.dao.EmployeeDAO;
import com.nobel.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	
	@Override
	@Transactional
	public List<Employee> getAll() {
		return employeeDAO.getAll();
	}

	@Override
	@Transactional
	public Employee getById(int id) {
		return employeeDAO.getById(id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		employeeDAO.deleteById(id);
	}

}
