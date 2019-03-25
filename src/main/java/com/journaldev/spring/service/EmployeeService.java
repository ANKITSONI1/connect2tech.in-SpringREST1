package com.journaldev.spring.service;

import java.util.List;

import com.c2t.annotation.basic.Employee;

public interface EmployeeService {

	Employee getSingleData(Long id);

	List<Employee> getAllEmployee();

	List<Employee> deleteEmployee(Long id);

}
