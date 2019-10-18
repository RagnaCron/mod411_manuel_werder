package MathLambdas;

import java.util.function.IntUnaryOperator;

public class LambdaMath {

	private static IntUnaryOperator factorial;

	public static void main(String[] args) {

		factorial = n -> n == 0 ? 1 : n * factorial.applyAsInt( n - 1);
		System.out.println("Factorial: " + factorial.applyAsInt(5));

	}

}
