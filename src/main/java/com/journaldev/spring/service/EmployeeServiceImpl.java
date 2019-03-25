package com.journaldev.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c2t.annotation.basic.Employee;
import com.journaldev.spring.Dao.EmployeeDao;
import com.journaldev.spring.Dao.EmployeeDaoImp;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDaoImp empDao;

	@Override
	public Employee getSingleData(Long id) {
		return empDao.getSingleData(id);
	}

	@Override
	public List<Employee> getAllEmployee() {

		return empDao.getAllEmployee();
	}

	@Override
	public List<Employee> deleteEmployee(Long id) {

		return empDao.deleteEmployee(id);
	}

}
