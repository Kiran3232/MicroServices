package com.application.compareemployees.model;

public class Employee {

	private Integer employeeId;

	private String employeeName;

	private Integer employeeAge;

	private String employeeRole;

	private Integer employeeSalary;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(Integer employeeAge) {
		this.employeeAge = employeeAge;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	public Integer getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(Integer employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public Employee(Integer employeeId, String employeeName, Integer employeeAge, String employeeRole,
			Integer employeeSalary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
		this.employeeRole = employeeRole;
		this.employeeSalary = employeeSalary;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeAge=" + employeeAge
				+ ", employeeRole=" + employeeRole + ", employeeSalary=" + employeeSalary + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeAge == null) ? 0 : employeeAge.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result + ((employeeRole == null) ? 0 : employeeRole.hashCode());
		result = prime * result + ((employeeSalary == null) ? 0 : employeeSalary.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeAge == null) {
			if (other.employeeAge != null)
				return false;
		} else if (!employeeAge.equals(other.employeeAge))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (employeeRole == null) {
			if (other.employeeRole != null)
				return false;
		} else if (!employeeRole.equals(other.employeeRole))
			return false;
		if (employeeSalary == null) {
			if (other.employeeSalary != null)
				return false;
		} else if (!employeeSalary.equals(other.employeeSalary))
			return false;
		return true;
	}
}
