package com.hw.person;

public class Test {
	
	private static void sendMail(Person person) {
		System.out.println();
		System.out.println("Kime: "+person.getEmailAdress());
		System.out.println("Konu: "+person.getGreeting());
		System.out.println("Gövde: "+person.getFullname());

	}
	
	public static void main(String[] args) {
		Employee employee = new Employee(201,"Erkan","Ocaklı",5470,"erkan@godoro.com");
		sendMail(employee);
	}
}
