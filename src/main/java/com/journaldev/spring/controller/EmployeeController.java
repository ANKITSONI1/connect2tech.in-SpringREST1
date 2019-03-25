package com.journaldev.spring.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.c2t.annotation.basic.Employee;
import com.c2t.annotation.basic.Employee2;
import com.c2t.annotation.basic.EmployeeVO;
import com.journaldev.spring.service.EmployeeService;

@Controller
class EmployeeController {

	@Autowired
	SessionFactory sf;

	@Autowired
	private EmployeeService empService;

	@RequestMapping(value = "rest/emp/getsingledata", method = RequestMethod.GET)
	public @ResponseBody Employee getDummy() {
		return empService.getSingleData(1l);
	}

	@RequestMapping(value = "rest/emp/setData", method = RequestMethod.GET)
	public @ResponseBody Employee2 getDummy2() {
		Session session = sf.openSession();

		Employee2 emp1 = new Employee2();
		Employee emp2 = new Employee();
		emp1.setFirstname("silence");
		emp1.setCellphone("9999");
		emp1.setLastname("soni");
		emp2.setFirstname("silence");
		emp2.setCellphone("9999");
		emp2.setLastname("soni");
		session.beginTransaction();
		session.save(emp1);
		session.save(emp2);
		session.getTransaction().commit();
		return emp1;
	}

	@RequestMapping(value = "rest/em/dummy/getAllData", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getDummy3() {

		return empService.getAllEmployee();
	}
	//
	// @RequestMapping(value = "rest/em/dummy/list", method = RequestMethod.GET)
	// public @ResponseBody EmployeeVO getDummyEmployeeList()
	//
	// {
	//
	// Query q = sf.openSession().createQuery("from Employee");
	// List<Employee> list = q.list();
	// EmployeeVO e1 = new EmployeeVO();
	// e1.setEmployees(list);
	// return e1;
	//
	// }

	@RequestMapping(value = "rest/em/dummy/getById/{id}", method = RequestMethod.GET)
	public @ResponseBody Employee getEmployee(@PathVariable Long id)

	{

		return empService.getSingleData(id);
	}

	@RequestMapping(value = "rest/em/dummy/remove/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Employee> removeEmployee(@PathVariable Long id)

	{

		return empService.deleteEmployee(id);

	}

}