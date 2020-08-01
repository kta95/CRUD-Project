package com.kta.springboot.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kta.springboot.demo.entity.Employee;
import com.kta.springboot.demo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	// add mapping for "/list"
	@GetMapping("/list") 
	public String listEmployees(Model model) { 
		// add to the spring model
		List<Employee> theEmployees = service.getAll(); 
		model.addAttribute("employees", theEmployees);
		return "employees/list-employee";
	}
	
	// add mapping for "/showFromForAdd"
	@GetMapping("/showFormForAdd")
	public String showFromForAdd(Model model) {
		
		Employee theEmployee = new Employee();
		
		model.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model model) {
		
		// get the employee from the service
		Employee theEmployee = service.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("employee", theEmployee);
		
		// send over to our form
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		// save the employee
		service.save(employee);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		
		// delete the employee
		service.deleteById(theId);
		
		// redirect to /employee/list
		return "redirect:/employees/list";
	}
}
