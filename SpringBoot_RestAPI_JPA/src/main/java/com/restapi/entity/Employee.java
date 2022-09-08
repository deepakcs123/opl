package com.restapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	private String empName;
	private String empContact;
	private String empAddress;
	public Employee(int empId, String empName, String empContact, String empAddress) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empContact = empContact;
		this.empAddress = empAddress;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpContact() {
		return empContact;
	}
	public void setEmpContact(String empContact) {
		this.empContact = empContact;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empContact=" + empContact + ", empAddress="
				+ empAddress + "]";
	}
	
	
	
}
