package com.hw.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.hw.entity.Department;
import com.hw.entity.Employee;

public class EmployeeManager extends BaseManager<Employee>{

	
	public EmployeeManager() {
		super();
	}
	
	protected Employee parse(ResultSet resultSet) throws SQLException {
		Employee employee;
		long employeeid = resultSet.getLong("employeeid");
		String employeeName = resultSet.getString("employeeName");
		double monthSalary = resultSet.getDouble("monthSalary");
		
		Department department = new Department(resultSet.getLong("departmentId"),resultSet.getString("departmentName"));
		employee = new Employee(employeeid,employeeName,monthSalary);
		employee.setDepartment(department);
		return employee;
	}
	
	public List<Employee> list() throws Exception{
		
		List<Employee> employees = new ArrayList<>();
		connect();
		
		String sql ="select e.employeeId, e.employeeName, e.monthSalary,e.departmentId, d.departmentName   "
				+ "from employee e "
				+ "join department d ON e.departmentId = d.departmentId";
		PreparedStatement statement =  connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		employees = parseList(employees, resultSet);
		
		
		disconnect();
		
		
		return employees;
	}
	
	public Employee find(long employeeId) throws Exception{
		Employee employee = null;
		

		connect();
		
		String sql ="select e.employeeId, e.employeeName, e.monthSalary,e.departmentId, d.departmentName   "
				+ "from employee e "
				+ "join department d ON e.departmentId = d.departmentId AND e.employeeId = ?";
		
		PreparedStatement statement =  connection.prepareStatement(sql);
		statement.setDouble(1, employeeId);
		ResultSet resultSet = statement.executeQuery();
		
		
		if(resultSet.next()) {
			employee = parse(resultSet);	
			return employee;
		}
		
		disconnect();
		return employee;
		
	}

}
