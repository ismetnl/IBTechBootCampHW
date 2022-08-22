package com.hw.manager;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hw.entity.Department;


public class DepartmentManager extends BaseManager<Department>{

	public DepartmentManager() {
		super();
	}
	
	protected Department parse(ResultSet resultSet) throws SQLException {
		Department department;
		long departmentId = resultSet.getLong("departmentId");
		String departmentName = resultSet.getString("departmentName");
		
		department = new Department(departmentId,departmentName);
		return department;
	}
	
	
}
