package com.application.employeeservice.dao;

import org.springframework.data.repository.CrudRepository;

import com.application.employeeservice.model.Employee;

public interface EmployeeServiceDao extends CrudRepository<Employee, Integer> {

}
