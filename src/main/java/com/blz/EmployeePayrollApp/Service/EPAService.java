package com.blz.EmployeePayrollApp.Service;

import java.util.ArrayList;
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

	private List<EPAData> employeePayrollList = new ArrayList<>();

	@Override
	public List<EPAData> getEPAData() {
		List<EPAData> empData = new ArrayList<>();
		return employeePayrollList;
	}

	@Override
	public EPAData getEPADataById(int empId) {
		return employeePayrollList.stream().filter(list -> list.getEmployeeId() == empId).findFirst()
				.orElseThrow(() -> new EmployeePayrollException("Employee not present"));
	}

	@Override
	public EPAData createEPAData(EPADTO ePADTO) {
		EPAData empData = null;
		empData = new EPAData(ePADTO);
		employeePayrollList.add(empData);
		log.debug("Employee Data: " + empData.toString());
		return employeeRepository.save(empData);
	}

	@Override
	public EPAData updateEPAData(int empId, EPADTO employeePayrollDTO) {
		EPAData empData = this.getEPADataById(empId);
		empData.setName(employeePayrollDTO.name);
		empData.setSalary(employeePayrollDTO.salary);
		employeePayrollList.set(empId - 1, empData);
		return empData;
	}

	@Override
	public void deleteEPAData(int empId) {
		// TODO Auto-generated method stub
		employeePayrollList.remove(empId - 1);
	}
}