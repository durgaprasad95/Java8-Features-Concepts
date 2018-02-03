package com.demo.lambda;

public class Calculator {

	interface IntegerMath {
		int operation(int a, int b);

		static int multiplication(int a, int b) {
			return a * b;
		}

		default float division(int a, int b) {
			return (float) a / b;
		}
	}

	public int operateBinary(int a, int b, IntegerMath op) {
		return op.operation(a, b);
	}

	public static void main(String... args) {

		Calculator myApp = new Calculator();
		IntegerMath addition = (a, b) -> a + b;
		IntegerMath multiplication = IntegerMath::multiplication;
		IntegerMath subtraction = (a, b) -> a - b;
		System.out.println("40 + 2 = " + myApp.operateBinary(40, 2, addition));
		System.out.println("40 * 2 = " + myApp.operateBinary(40, 2, multiplication));
		System.out.println("20 - 10 = " + myApp.operateBinary(20, 10, subtraction));
	}
}