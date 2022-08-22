package com.hw.geometry;


public class Circle {
	
	private double radius;

	public Circle(double radius) {
		
		this.radius = radius;
	}

	public Circle() {
		
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea(){
		return Math.PI*Math.pow(this.radius, 2);
	}
	public double getPerimeter() {
		return 2*Math.PI*this.radius;
	}
	
}
