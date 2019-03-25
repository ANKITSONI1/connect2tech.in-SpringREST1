package com.journaldev.spring.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.c2t.annotation.basic.Employee;

@Repository
public class EmployeeDaoImp implements EmployeeDao{

	@Autowired
	SessionFactory sf;

	@Override
	public Employee getSingleData(Long id) {
		Session session = sf.openSession();
		Employee emp = (Employee) session.get(Employee.class, id);

		return emp;
	}

	@Override
	public List<Employee> getAllEmployee() {
		Session session = sf.openSession();
		String s = "select s from Employee s";


		List<Employee> emp = (List<Employee>) session.createQuery(s).list();

		return emp;
	}

	@Override
	public List<Employee> deleteEmployee(Long id) {
		Session session = sf.openSession();
		session.beginTransaction();
		Employee emp = (Employee) session.get(Employee.class, id);

		session.delete(emp);
		session.getTransaction().commit();
		String s = "select s from Employee s";

		List<Employee> emp1 = (List<Employee>) session.createQuery(s).list();

		return emp1;
	}
	
}
