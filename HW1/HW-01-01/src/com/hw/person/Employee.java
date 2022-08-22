package com.hw.person;

public class Employee extends Person{
	
	private long employeeId;
	private double monthlySalary;

	
	
	public Employee( long employeeId,String firstname, String lastname , double monthlySalary,String emailAdress) {
		super(firstname, lastname, emailAdress);
		this.employeeId = employeeId;
		this.monthlySalary = monthlySalary;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public double getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	@Override
	public String getGreeting() {
		return "Selamlar, nasılsınız?";
		
	}
	
	
}
