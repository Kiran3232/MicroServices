package com.application.employeeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.employeeservice.dao.EmployeeServiceDao;
import com.application.employeeservice.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeServiceController {

	@Autowired
	private EmployeeServiceDao employeeServiceDao;
	
	@GetMapping("/getEmployees")
	public List<Employee> getEmployees(){
		List<Employee> employeeList = (List<Employee>) employeeServiceDao.findAll();
		System.out.println(employeeList);
		return employeeList;
	}
}
