package com.hw.functions;

public class Test {
	public static void main(String[] args) {
		FunctionDrawer drawer = new FunctionDrawer();
		
		System.out.println();
		System.out.println("Identity Function");
		IdentityFunction f1=new IdentityFunction();
		drawer.draw(f1,10,15,100);
		
		System.out.println();
		System.out.println("Quadratic Polynomial");
		QuadraticPolynomial quadratic = new QuadraticPolynomial(2, 3, 5);
		drawer.draw(quadratic,-5,5,100);
		
		System.out.println();
		System.out.println("Sinusoidal Polynomial");
		SinusoidalPolynomial sinusoiadal = new SinusoidalPolynomial(3, 5, 7);
		drawer.draw(sinusoiadal,-Math.PI,Math.PI,100);
		
	}
}
