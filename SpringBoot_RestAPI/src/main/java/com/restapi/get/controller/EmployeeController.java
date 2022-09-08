package com.restapi.get.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.get.entity.Employee;
import com.restapi.get.service.EmployeeService;

/*//@RestController
*/public class EmployeeController {

	@Autowired
	private Employee employee;
	@Autowired
	private EmployeeService emps;

	// @RequestMapping(value = "/employee", method = RequestMethod.GET)
	// @ResponseBody
	@GetMapping("/employee1")
	public Employee getEmployee() {
		employee.setEmpId(100);
		employee.setEmpName("Indore");
		employee.setEmpContact("9827375391");
		employee.setEmpAddress("Indore Mp");
		return employee;
	}

	// Get All Employees

	@GetMapping("/employee")
	public List<Employee> getAllEmp() {
		return emps.getAllEmployees();
	}

	// Get Single Employee

	@GetMapping("/employee/{id}")
	public Employee getEmp(@PathVariable("id") int id) {
		Employee singleEmp = this.emps.getSingleEmp(id);
		return singleEmp;
	}

	// Save Employee
	@PostMapping("/employee")
	public Employee saveEmp(@RequestBody Employee emp) {
		Employee saveEmployee = this.emps.saveEmployee(emp);
		return saveEmployee;
	}

	// Delete Single Employee
	@DeleteMapping("/employee/{id}")
	public void deleteEmp(@PathVariable("id") int id) {
		this.emps.deleteEmployee(id);
	}

	@DeleteMapping("/employee")
	public void deleteAllEmp() {
		this.emps.deleteAllEmployee();
	}

	@PutMapping("/employee/{id}")
	public void updateEmp(@RequestBody Employee emp, @PathVariable("id") int id) {
		this.emps.updateEmployee(emp, id);
	}

}
