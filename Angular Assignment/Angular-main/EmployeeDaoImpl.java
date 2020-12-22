package com.empapp.model.dao;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	private SessionFactory factory;
	public EmployeeDaoImpl(SessionFactory factory) {
		this.factory=factory;
	}
	private Session getSession() {
		return factory.getCurrentSession();
	}
	public List<Employee> getAll() {
		return getSession().createQuery("from Employee").getResultList();
	}

	public Employee getEmployeeById(int id) {
		Employee emp=getSession().get(Employee.class, id);
		if(emp==null)
			throw new EmployeeNotFoundException("Not found");
		else
		return emp;
	}

	public Employee save(Employee emp) {
		 getSession().save(emp);
		 return emp;
	}

	public Employee delete(int empId) {
		Employee empDelete=getEmployeeById(empId);
		getSession().delete(empDelete);
		return empDelete;
	}

	public Employee update(int empId, Employee emp) {
		Employee empUpdate=getEmployeeById(empId);
		empUpdate.setAge(emp.getAge());
		empUpdate.setName(emp.getName());
		return empUpdate;
	}

}
