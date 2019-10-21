package Sort;

import TimeMeasurement.Operations;

import java.util.function.Consumer;

public class SortingMain {



//	private static <T> void measureRuntime(T[] list, String sortingName, String typeName, Consumer<T[]> sorter) {
//		long startTime = System.nanoTime();
//		sorter.accept(list);
//		long stopTime = System.nanoTime();
//		double milliseconds = (stopTime - startTime) / 1000000.0;
//		System.out.println("Runtime of " + sortingName + " on " + typeName + " in milliseconds: " + milliseconds);
//		for (T value : list) System.out.print(value + " ");
//	}

	private static <T> void measureRuntime(T[] list, String sortingName, String typeName, Consumer<T[]> function) {
		long startTime = System.nanoTime();
		function.accept(list);
		long stopTime = System.nanoTime();
		long milliseconds = (stopTime - startTime) / 1000000;
		System.out.println("Runtime of " + sortingName + " on " + typeName + " in milliseconds: " + milliseconds);
		for (T value : list) System.out.print(value + " ");
	}

	public static void main(String[] args) {
		System.out.println();

		Integer[] bubbleSortIntegerList = Operations.getRandomIntegerList(1000);
		measureRuntime(bubbleSortIntegerList, "BubbleSort", "Integer", list -> new BubbleSort<Integer>().sort(list));

		System.out.println("\n");

		String[] bubbleSortStringList = Operations.getRandomStringList(1000);
		measureRuntime(bubbleSortStringList, "BubbleSort", "String", list -> new BubbleSort<String>().sort(list));

		System.out.println("\n");

		Integer[] insertionSortIntegerList = Operations.getRandomIntegerList(1000);
		measureRuntime(insertionSortIntegerList, "InsertionSort", "Integer", list ->  new InsertionSort<Integer>().sort(list));

		System.out.println("\n");

		String[] insertionSortStringList = Operations.getRandomStringList(1000);
		measureRuntime(insertionSortStringList, "InsertionSort", "String", list -> new InsertionSort<String>().sort(list));

		System.out.println("\n");

		Integer[] quickSortIntegerList = Operations.getRandomIntegerList(10000);
		measureRuntime(quickSortIntegerList, "QuickSort", "Integer", list ->  new QuickSort<Integer>().sort(list));

//		System.out.println("\n");
//
//		String[] quickSortIntegerStringList = getRandomIntegerStringList(10000);
//		measureRuntime(quickSortIntegerStringList, "QuickSort", "String", list -> new QuickSort<String>().sort(list));

		System.out.println("\n");

		String[] quickSortStringList = Operations.getRandomStringList(10000);
		measureRuntime(quickSortStringList, "QuickSort", "String", list -> new QuickSort<String>().sort(list));

	}

}