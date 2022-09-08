package com.restapi.get.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.restapi.get.entity.Employee;

@Service
public class EmployeeService {

	private static List<Employee> emplist = new ArrayList<>();
	static {

		emplist.add(new Employee(100, "Deepak Vishwakarma", "8770811244", "Indore MP"));
		emplist.add(new Employee(200, "Rakesh Jain", "9770411244", "Indore MP"));
		emplist.add(new Employee(300, "Umesh Sahu", "7770811255", "Bhopal MP"));
		emplist.add(new Employee(400, "Sourabh Vishwakarma", "8770811234", "Jabalpur MP"));
	}

	public List<Employee> getAllEmployees() {

		return emplist;

	}

	public Employee getSingleEmp(int id) {
		/*
		 * for (Employee employee : emplist) { if (employee.getEmpId() == id) { return
		 * new Employee(employee.getEmpId(), employee.getEmpName(),
		 * employee.getEmpContact(), employee.getEmpAddress()); } } return null;
		 */
		Employee employee=null;
		try {
			 employee = emplist.stream().filter(emp->emp.getEmpId()==id).findFirst().get();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return employee;

	}
	public Employee saveEmployee(Employee emp)
	{
		try {
			emplist.add(emp);
			return emp;
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
	}
	
	public boolean deleteEmployee(int id)
	{
		/*
		 * emplist=emplist.stream().filter(emp->{ if(emp.getEmpId()!=id) { return true;
		 * }else { return false;} }).collect(Collectors.toList());
		 */
		
		try {
			emplist= emplist.stream().filter(emp->emp.getEmpId()!=id).collect(Collectors.toList());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteAllEmployee()
	{
		try {
			emplist.clear();
			return true;
		} catch (Exception e) {
			//e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateEmployee(Employee emp ,int id)
	{
		try {
			emplist = emplist.stream().map(e->{
				if(e.getEmpId()==id)
				{
					e.setEmpName(emp.getEmpName());
					e.setEmpContact(emp.getEmpContact());
					e.setEmpAddress(emp.getEmpAddress());
				}return e;
				
			}).collect(Collectors.toList());
			
			return true;
		} catch (Exception e) {
			//e.printStackTrace();
			return false;
		}
	}

}
