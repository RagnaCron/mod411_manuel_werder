package TimeMeasurement;

import Sort.BubbleSort;
import Sort.InsertionSort;
import Sort.QuickSort;

public class PerformancesMeasurement {

	public static void main(String[] args) {

		System.out.println("\n----- Insertion Performance Testing -----");
		System.out.println("Static array, runtime: " +
				Measurement.measureRuntime(Operations::insertIntoStaticArray, Operations.TEN_MILLION));
//		System.out.println("Static array lambda style, runtime: " +
//				Measurement.measureRuntime(Operations::insertIntoStaticArrayLambdaStyle, Operations.MILLION));
		System.out.println("Array list, runtime: " +
				Measurement.measureRuntime(Operations::insertIntoArrayList, Operations.TEN_MILLION));

		System.out.println("\n----- Deleting Performance Testing -----");
		System.out.println("Static array, runtime: " +
				Measurement.measureRuntime(Operations::deleteFromArrayList,
						Operations.getRandomIntegerArrayList(Operations.MILLION)));

		System.out.println("\n----- Sorting Performance Testing -----");
		System.out.println("BubbleSort integers, runtime: " +
				Measurement.measureRuntime(list -> new BubbleSort<Integer>().sort(list),
						Operations.getRandomIntegerArray(Operations.TEN_THOUSAND)));
		System.out.println("InsertionSort integers, runtime: " +
				Measurement.measureRuntime(list -> new InsertionSort<Integer>().sort(list),
						Operations.getRandomIntegerArray(Operations.TEN_THOUSAND)));
		System.out.println("QuickSort integers, runtime: " +
				Measurement.measureRuntime(list -> new QuickSort<Integer>().sort(list),
						Operations.getRandomIntegerArray(Operations.TEN_THOUSAND)));

	}

}
