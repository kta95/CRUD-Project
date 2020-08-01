package com.kta.springboot.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kta.springboot.demo.entity.Employee;

public interface EmployeeRespository extends JpaRepository<com.kta.springboot.demo.entity.Employee, Integer> {

	// add a method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
}
