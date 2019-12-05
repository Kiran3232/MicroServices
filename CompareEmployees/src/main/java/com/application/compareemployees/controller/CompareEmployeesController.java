package com.application.compareemployees.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.compareemployees.CompareEmployeesService;
import com.application.compareemployees.model.Employee;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/compare")
public class CompareEmployeesController {
	
	@Autowired
	CompareEmployeesService compareEmployeesService;
	
	@RequestMapping("/salary/{employeeId1}/{employeeId2}")
	@HystrixCommand(fallbackMethod= "compareSalaryFallback")
	public String compareSalary(@PathVariable Integer employeeId1,@PathVariable Integer employeeId2){
		String result = "";
		Employee employee1 = compareEmployeesService.getEmployee(employeeId1);
		Employee employee2 = compareEmployeesService.getEmployee(employeeId2);
		if(employee1.getEmployeeSalary()>employee2.getEmployeeSalary()){
			result = employee1.getEmployeeName() + " earns more than " + employee2.getEmployeeName();
		}
		else if(employee1.getEmployeeSalary()<employee2.getEmployeeSalary()){
			result = employee2.getEmployeeName() + " earns more than " + employee1.getEmployeeName();
		}
		else {
			result = employee1.getEmployeeName() + " earns the same as " + employee2.getEmployeeName();
		}
		return result;
	}
	
	@SuppressWarnings("unused")
	public String compareSalaryFallback(Integer employeeId1, Integer employeeId2){
		return "The Employee service did not send any response at the moment - Please try again later";
	}
}
