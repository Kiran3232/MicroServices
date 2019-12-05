package com.application.compareemployees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.application.compareemployees.model.Employee;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Service
public class CompareEmployeesService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Value("employee-service")
	private String employeeServiceId;
	
	public Employee getEmployee(Integer employeeId){
		Application application = eurekaClient.getApplication(employeeServiceId);
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/employee/getEmployee/"+ employeeId;
		Employee employee = restTemplate.getForObject(url, Employee.class);
		return employee;
	}
	
}