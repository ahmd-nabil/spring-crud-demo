package com.nobel.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nobel.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Employee> getAll() {
		Query theQuery = entityManager.createQuery("from Employee");
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee getById(int id) {
		Employee theEmployee = entityManager.find(Employee.class, id);
		return theEmployee;
	}

	@Override
	public void save(Employee employee) {
		Employee dbEmployee = entityManager.merge(employee);
	}

	@Override
	public void deleteById(int id) {
		Query theQuery = entityManager.createQuery("delete from Employee where id=:id");
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();
	}

}
