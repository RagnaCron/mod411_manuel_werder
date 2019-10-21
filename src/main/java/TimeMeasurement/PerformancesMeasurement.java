package TimeMeasurement;

import Sort.BubbleSort;
import Sort.InsertionSort;

public class PerformancesMeasurement {

	public static void main(String[] args) {

		System.out.println("\n----- Insertion Performance Testing -----");
		System.out.println("Static array, runtime: " +
				Measurement.measureRuntime(Operations::insertIntoStaticArray, Operations.MILLION));
//		System.out.println("Static array lambda style, runtime: " +
//				Measurement.measureRuntime(Operations::insertIntoStaticArrayLambdaStyle, Operations.MILLION));
		System.out.println("Array list, runtime: " +
				Measurement.measureRuntime(Operations::insertIntoArrayList, Operations.MILLION));

		System.out.println("\n----- Sorting Performance Testing -----");
		Integer[] integers = Operations.getRandomIntegerList(Operations.TEN_THOUSAND);
		System.out.println("BubbleSort integers, runtime: " +
				Measurement.measureRuntime(list -> new BubbleSort<Integer>().sort(list), integers));
		integers = Operations.getRandomIntegerList(Operations.TEN_THOUSAND);
		System.out.println("InsertionSort integers, runtime: " +
				Measurement.measureRuntime(list -> new InsertionSort<Integer>().sort(list), integers));
	}

}
