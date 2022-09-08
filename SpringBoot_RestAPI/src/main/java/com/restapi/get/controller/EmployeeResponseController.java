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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.get.entity.Employee;
import com.restapi.get.service.EmployeeService;

@RestController
public class EmployeeResponseController {
	@Autowired
	private EmployeeService empservice;

	@Autowired
	private Employee emp;

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getSingleEmployee(@PathVariable("id") int id) {
		Employee employee = empservice.getSingleEmp(id);
		if (employee == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(employee));
	}

	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> employee = empservice.getAllEmployees();
		if (employee == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(employee));
	}

	@PostMapping("/employee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {
		Employee emp1 = this.empservice.saveEmployee(emp);
		if (emp1 != null)
			return ResponseEntity.of(Optional.of(emp1));
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int eid) {

		boolean deleteEmployee = this.empservice.deleteEmployee(eid);
		if (deleteEmployee != false)
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

	}

	@DeleteMapping("/employee")
	public ResponseEntity<Void> deleteAll() {

		boolean deleteAllEmployee = this.empservice.deleteAllEmployee();
		if (deleteAllEmployee != false)
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

	}
}
