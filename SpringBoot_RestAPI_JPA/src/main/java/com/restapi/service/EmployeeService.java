package com.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.entity.Employee;
import com.restapi.repository.EmpRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmpRepository emprep;

	// Get Single record
	public Employee getEmploye(int eid) {
		Employee employee = this.emprep.findById(eid);
		return employee;
	}

	// Get All records
	public List<Employee> getAllEmployee() {
		List<Employee> employees = this.emprep.findAll();
		return employees;
	}

	// Save Single record
	public Employee saveEmployee(Employee emp) {
		Employee employee = this.emprep.save(emp);
		return employee;
	}

	// Delete Single record
	public void deleteEmployee(int eid) {
		this.emprep.deleteById(eid);
	}

	// Delete All records
	public void deleteAllEmployee() {
		this.emprep.deleteAll();
	}
	
	//Update Record
	public Employee updateRecord(Employee employee,int id)
	{
		employee.setEmpId(id);
		Employee emp = this.emprep.save(employee);
		return emp;
	}
}
