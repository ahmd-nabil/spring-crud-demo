package com.nobel.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nobel.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define a field for entity manager (as I know, this is a wrapper for hibernate sessionfactory)
	private EntityManager entityManager;
	
	// setup constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> getAll() {
		// get current hibernate session
		Session session = entityManager.unwrap(Session.class);
		// create the query
		Query<Employee> theQuery = session.createQuery("from Employee", Employee.class);
		// execute the query and get the list
		List<Employee> employeesList = theQuery.getResultList();
		// return the list
		return employeesList;
	}

	@Override
	public Employee getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Employee employee = session.get(Employee.class, id);
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(employee); //if id = 0 insert, otherwise it updates
	}

	@Override
	public void deleteById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query theQuery = session.createQuery("DELETE FROM Employee WHERE id=:employeeId");
		theQuery.setParameter("employeeId", id);
		theQuery.executeUpdate();
	}
}
