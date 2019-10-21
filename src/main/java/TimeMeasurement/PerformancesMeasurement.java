package TimeMeasurement;

import Sort.BubbleSort;
import Sort.InsertionSort;
import Sort.QuickSort;

@SuppressWarnings("all")
public class PerformancesMeasurement {

	public static void main(String[] args) {

		System.out.println("\n----- Creation Performance Testing -----");
		System.out.println("Static array, runtime: " +
				Measurement.measureRuntime(Operations::createIntegerArray, Operations.TEN_MILLION));
		System.out.println("Array list, runtime: " +
				Measurement.measureRuntime(Operations::createIntegerArrayList, Operations.TEN_MILLION));

		System.out.println("\n----- Insertion Performance Testing -----");
		System.out.println("Static array, runtime: " +
				Measurement.measureRuntime(Operations::insertIntoStaticArray,
						Operations.createIntegerArray( Operations.TEN_MILLION)));
		System.out.println("Array list, runtime: " +
				Measurement.measureRuntime(Operations::insertIntoArrayList,
						Operations.TEN_MILLION));

		System.out.println("\n----- Deletion Performance Testing -----");
		System.out.println("Array list, removing from 0..<n, runtime: " +
				Measurement.measureRuntime(Operations::deleteFromArrayListFront,
						Operations.getRandomIntegerArrayList(Operations.HUNDRED_THOUSAND)));
		System.out.println("Array list, removing form n>..0, runtime, " +
				Measurement.measureRuntime(Operations::deleteFromArrayListBack,
						Operations.getRandomIntegerArrayList(Operations.HUNDRED_THOUSAND)));

		System.out.println("\n----- Sortation Performance Testing -----");
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
