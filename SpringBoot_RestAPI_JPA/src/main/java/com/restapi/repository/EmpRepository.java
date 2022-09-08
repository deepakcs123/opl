package com.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {

	public Employee findById(int id);
}
