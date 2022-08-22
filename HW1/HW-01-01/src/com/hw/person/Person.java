package com.hw.person;

abstract public class Person {
	
	private String firstname;
	private String lastname;
	private String emailAdress;
	
	

	
	public Person(String firstname, String lastname, String emailAdress) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailAdress = emailAdress;
	}
	
	
	public String getEmailAdress() {
		return emailAdress;
	}


	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}


	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getFullname() {
		return firstname+" "+lastname;
	}
	
	abstract public String getGreeting();
	
	
}
