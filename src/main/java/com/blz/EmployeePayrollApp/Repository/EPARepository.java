package com.blz.EmployeePayrollApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blz.EmployeePayrollApp.Model.EPAData;

public interface EPARepository extends JpaRepository<EPAData, Integer> {

}
