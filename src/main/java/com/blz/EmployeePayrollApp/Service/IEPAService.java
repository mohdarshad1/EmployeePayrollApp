package com.blz.EmployeePayrollApp.Service;

import java.util.List;

import com.blz.EmployeePayrollApp.DTO.EPADTO;
import com.blz.EmployeePayrollApp.Model.EPAData;

public interface IEPAService {

	List<EPAData> getEPAData();

	EPAData getEPADataById(int empId);

	List<EPAData> getEmployeesByDepartment(String department);

	EPAData createEPAData(EPADTO EPADTO);

	EPAData updateEPAData(int empId, EPADTO employeePayrollDTO);

	void deleteEPAData(int empId);
}