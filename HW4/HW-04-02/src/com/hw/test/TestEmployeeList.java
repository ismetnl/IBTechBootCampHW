package com.hw.test;

import java.util.List;

import com.hw.entity.Employee;
import com.hw.manager.EmployeeManager;

public class TestEmployeeList {
	public static void main(String[] args) throws Exception {
		EmployeeManager customerManager = new EmployeeManager();
		List<Employee> employees = customerManager.list();
		
		for(Employee employee : employees) {
			System.out.println(employee.getEmployeeId()+" "
					+employee.getEmployeeName()+" "
					+employee.getMonthSalary()+" "
					+employee.getDepartment().getDepartmentName());
		}
	}
}
