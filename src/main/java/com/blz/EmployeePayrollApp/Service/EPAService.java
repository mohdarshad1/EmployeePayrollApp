package com.blz.EmployeePayrollApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blz.EmployeePayrollApp.DTO.EPADTO;
import com.blz.EmployeePayrollApp.Exception.EmployeePayrollException;
import com.blz.EmployeePayrollApp.Model.EPAData;
import com.blz.EmployeePayrollApp.Repository.EPARepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EPAService implements IEPAService {

	@Autowired
	private EPARepository employeeRepository;

	@Override
	public List<EPAData> getEPAData() {
		return employeeRepository.findAll();
	}

	@Override
	public EPAData getEPADataById(int empId) {
		return employeeRepository.findById(empId).orElseThrow(
				() -> new EmployeePayrollException("Employee with employee id: " + empId + " does not exists."));
	}

	@Override
	public List<EPAData> getEmployeesByDepartment(String department) {
		return employeeRepository.findEmployeesById(department);
	}
	
	@Override
	public List<EPAData> getEmployeesByKeywordName(String keyword) {
		return employeeRepository.getEmployeesByKeywordName(keyword);
	}

	@Override
	public EPAData createEPAData(EPADTO ePADTO) {
		EPAData empData = null;
		empData = new EPAData(ePADTO);
		log.debug("Employee Data: " + empData.toString());
		return employeeRepository.save(empData);
	}

	@Override
	public EPAData updateEPAData(int empId, EPADTO employeePayrollDTO) {
		EPAData empData = this.getEPADataById(empId);
		empData.updateEmployeePayrollData(employeePayrollDTO);
		return employeeRepository.save(empData);
	}

	@Override
	public void deleteEPAData(int empId) {
		EPAData employeeDataById = this.getEPADataById(empId);
		employeeRepository.delete(employeeDataById);
	}
}