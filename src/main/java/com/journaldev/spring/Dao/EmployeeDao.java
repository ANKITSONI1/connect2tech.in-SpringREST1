package com.journaldev.spring.Dao;

import java.util.List;

import com.c2t.annotation.basic.Employee;

public interface EmployeeDao {

	Employee getSingleData(Long id);

	List<Employee> getAllEmployee();

	List<Employee> deleteEmployee(Long id);

}
