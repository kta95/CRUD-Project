package com.kta.springboot.demo.service;

import java.util.List;

import com.kta.springboot.demo.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
}
