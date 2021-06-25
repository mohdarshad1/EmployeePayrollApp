package com.blz.EmployeePayrollApp.Model;

import com.blz.EmployeePayrollApp.DTO.EPADTO;

import lombok.Data;

@Data
public class EPAData {

	private int employeeId;
	private String name;
	private long salary;

	public EPAData() {
		// TODO Auto-generated constructor stub
	}
	
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	public void setSalary(long salary) {
		// TODO Auto-generated method stub
		
	}

	public EPAData(int employeeId, String name, long salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
	}

	public EPAData(int employeeId, EPADTO employeePayrollDTO) {
		super();
		this.employeeId = employeeId;
		this.name = employeePayrollDTO.name;
		this.salary = employeePayrollDTO.salary;
	}

	
}