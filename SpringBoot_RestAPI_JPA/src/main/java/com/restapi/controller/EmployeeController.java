 package com.restapi.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.restapi.entity.Employee;
import com.restapi.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService empservice;

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
		Employee employee = null;
		employee = this.empservice.getEmploye(id);
		if (employee == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else
			return ResponseEntity.of(Optional.of(employee));
	}

	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> employee = null;
		employee = this.empservice.getAllEmployee();
		if (employee == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else
			return ResponseEntity.of(Optional.of(employee));
	}

	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
		Employee saveEmployee = null;
		saveEmployee = this.empservice.saveEmployee(emp);
		if (saveEmployee == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else
			// return ResponseEntity.of(Optional.of(saveEmployee));
			return ResponseEntity.status(HttpStatus.CREATED).body(saveEmployee);
	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id) {
		try {
			this.empservice.deleteEmployee(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/employee")
	public ResponseEntity<Void> deleteAllEmployee() {
		try {
			this.empservice.deleteAllEmployee();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateRecord(@RequestBody Employee emp, @PathVariable("id") int id) {
		Employee employee = null;
		employee = this.empservice.updateRecord(emp, id);
		if (employee == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else
			// return ResponseEntity.of(Optional.of(saveEmployee));
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(employee);
	}
}
