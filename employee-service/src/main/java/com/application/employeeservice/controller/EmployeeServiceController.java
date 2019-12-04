package com.application.employeeservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.employeeservice.dao.EmployeeServiceDao;
import com.application.employeeservice.model.Employee;

@RestController
public class EmployeeServiceController {

	@Autowired
	private EmployeeServiceDao employeeServiceDao;
	
	@RequestMapping(value="/getEmployees",method = RequestMethod.GET)
	public List<Employee> getEmployees(){
		
	}
}
