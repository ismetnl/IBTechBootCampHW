package com.hw.functions;

public class QuadraticPolynomial implements MathFunction{

	private double a;
	private double b;
	private double c;
	
	
	
	public QuadraticPolynomial(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}



	public double getA() {
		return a;
	}



	public void setA(double a) {
		this.a = a;
	}



	public double getB() {
		return b;
	}



	public void setB(double b) {
		this.b = b;
	}



	public double getC() {
		return c;
	}



	public void setC(double c) {
		this.c = c;
	}



	@Override
	public double evaluate(double x) {
		return a*Math.pow(x, 2)+b*x+c;
	}
	
}
