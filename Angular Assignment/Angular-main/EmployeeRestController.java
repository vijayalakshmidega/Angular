package com.empapp.web.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empapp.model.dao.Employee;
import com.empapp.model.service.EmployeeService;

@CrossOrigin("*")
@RestController
public class EmployeeRestController {
	private EmployeeService empService;
	
	@PostConstruct
	public void init() {
		Employee e1=new Employee("raj",56);
		Employee e2=new Employee("raj",56);
		Employee e3=new Employee("raj",56);
		empService.save(e1);
		empService.save(e2);
		empService.save(e3);
	}
	
	@Autowired
	public EmployeeRestController(EmployeeService empService) {
		
		this.empService = empService;
	}

    @GetMapping("employee")
	public ResponseEntity<List<Employee>> getAllEmp(){
		List<Employee> emps=empService.getAll();
		return new ResponseEntity<List<Employee>>(emps,HttpStatus.OK);
	}
    @GetMapping("employee/{id}")
public Employee getEmpById(@PathVariable(name="id") int id) {
    Employee empId=empService.getEmployeeById(id);
   return empId;
    }
    
    @PostMapping("employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee empe)
    {
    	Employee employe=empService.save(empe);
    	return new ResponseEntity<Employee>(employe,HttpStatus.CREATED);
    }
    
    @PutMapping("employee/{id}")
    public Employee updateEmpById(@PathVariable(name="id") int id, @RequestBody Employee emp) {
        Employee empupdate=empService.update(id, emp);
       return empupdate;
        }
    @DeleteMapping("employee/{id}")
    public Employee deleteEmpById(@PathVariable(name="id") int id) {
        Employee empdelete=empService.delete(id);
       return empdelete;
        }
    
}
