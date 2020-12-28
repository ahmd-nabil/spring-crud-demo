package com.nobel.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nobel.springboot.cruddemo.entity.Employee;
import com.nobel.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> getAll() {
		return employeeService.getAll();
	}
	
	@GetMapping("/employees/{id}") // {id} same as @PathVariable parameter
	public Employee getEmployee(@PathVariable int id) {
		Employee employee = employeeService.getById(id);
		return employee;
	}
	
	@PostMapping("/employees")
	public void save(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.save(employee);
	}
	
	@PutMapping("/employees")
	public void update(@RequestBody Employee newEmp) {
		Employee oldEmp = employeeService.getById(newEmp.getId());
		if(oldEmp != null) {
			oldEmp.setFirstName(newEmp.getFirstName());
			oldEmp.setLastName(newEmp.getLastName());
			oldEmp.setEmail(newEmp.getEmail());
			employeeService.save(oldEmp);
		}
	}
	
	@DeleteMapping("/employees/{id}")
	public void delete(@PathVariable int id) {
		employeeService.deleteById(id);
	}
}

