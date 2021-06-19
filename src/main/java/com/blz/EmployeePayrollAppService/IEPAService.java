package com.blz.EmployeePayrollAppService;

import java.util.List;

import com.blz.EmployeePayrollAppDTO.EPADTO;
import com.blz.EmployeePayrollAppModel.EPAData;

public interface IEPAService {

	List<EPAData> getEPAData();

	EPAData getEPADataById(int empId);

	EPAData createEPAData(EPADTO EPADTO);

	EPAData updateEPAData(EPADTO EPADTO);

	void deleteEPAData(int empId);
}
