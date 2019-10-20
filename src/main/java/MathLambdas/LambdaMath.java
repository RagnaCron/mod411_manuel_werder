package MathLambdas;

import java.util.function.DoubleUnaryOperator;
import java.util.function.IntUnaryOperator;

public class LambdaMath {

	private static IntUnaryOperator factorial;
	private static IntUnaryOperator fibonacci;

//	private static DoubleUnaryOperator goldenFibonacciRatio;



	public static void main(String[] args) {
		System.out.println();

		factorial = n -> n == 0 ? 1 : n * factorial.applyAsInt( n - 1);
		System.out.println("Factorial: " + factorial.applyAsInt(5));

		System.out.println();

		fibonacci = n -> n < 3 ? 1 : fibonacci.applyAsInt(n - 1) + fibonacci.applyAsInt( n - 2);
		System.out.println("Fibonacci: " + fibonacci.applyAsInt(5));

		System.out.println();

//		goldenFibonacciRatio = n -> fibonacci.applyAsInt((int) n - 1) / (Double) fibonacci.applyAsInt( (int) n - 2);
//		System.out.println("Golden Fibonacci Ratio: " + goldenFibonacciRatio.applyAsDouble(5));

	}

}
