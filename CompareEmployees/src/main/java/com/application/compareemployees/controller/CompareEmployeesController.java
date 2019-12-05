package com.application.compareemployees.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.application.compareemployees.model.Employee;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/compare")
public class CompareEmployeesController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Value("employee-service")
	private String employeeServiceId;
	
	@HystrixCommand(fallbackMethod= "compareSalaryFallback")
	@RequestMapping("/salary/{employeeId1}/{employeeId2}")
	public String compareSalary(@PathVariable Integer employeeId1,@PathVariable Integer employeeId2){
		String result = "";
		Application application = eurekaClient.getApplication(employeeServiceId);
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/employee/getEmployee/"+ employeeId1;
		Employee employee1 = restTemplate.getForObject(url, Employee.class);
		url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/employee/getEmployee/"+ employeeId2;
		Employee employee2 = restTemplate.getForObject(url, Employee.class);
		if(employee1.getEmployeeSalary()>employee2.getEmployeeSalary()){
			result = employee1.getEmployeeName() + " earns more than " + employee2.getEmployeeName();
		}
		else{
			result = employee2.getEmployeeName() + " earns more than " + employee1.getEmployeeName();
		}
		return result;
	}
	
	@SuppressWarnings("unused")
	public String compareSalaryFallback(Integer employeeId1,Integer employeeId2){
		return "The Employee service did not send any response at the moment - Please try again later";
	}
}
