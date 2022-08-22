package com.hw.test;

import com.hw.entity.Employee;
import com.hw.manager.EmployeeManager;

public class TestEmployeeFind {
	public static void main(String[] args) throws Exception {
		EmployeeManager customerManager = new EmployeeManager();
		Employee employee = customerManager.find(2);
		
		
		System.out.println(employee.getEmployeeId()+" "
				+employee.getEmployeeName()+" "
				+employee.getMonthSalary()+" "
				+employee.getDepartment().getDepartmentName());
	
	}
}
