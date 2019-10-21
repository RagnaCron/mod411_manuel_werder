package Sort;

import TimeMeasurement.Measurement;
import TimeMeasurement.Operations;
import java.util.ArrayList;

public class SortingMain {



	public static void main(String[] args) {
		ArrayList<String> messageList = new ArrayList<>();

		Integer[] bubbleSortIntegerList = Operations.getRandomIntegerArray(Operations.THOUSAND);
		messageList.add("BubbleSort on integers, runtime: " +
			Measurement.measureRuntime(list -> new BubbleSort<Integer>().sort(list), bubbleSortIntegerList));

		String[] bubbleSortStringList = Operations.getRandomStringList(Operations.THOUSAND);
		messageList.add("BubbleSort on strings, runtime: " +
			Measurement.measureRuntime(list -> new BubbleSort<String>().sort(list), bubbleSortStringList));

		Integer[] insertionSortIntegerList = Operations.getRandomIntegerArray(Operations.THOUSAND);
		messageList.add("InsertionSort on integers, runtime: " +
			Measurement.measureRuntime(list ->  new InsertionSort<Integer>().sort(list), insertionSortIntegerList));

		String[] insertionSortStringList = Operations.getRandomStringList(Operations.THOUSAND);
		messageList.add("InsertionSort on strings, runtime: " +
			Measurement.measureRuntime(list -> new InsertionSort<String>().sort(list), insertionSortStringList));

		Integer[] quickSortIntegerList = Operations.getRandomIntegerArray(Operations.TEN_THOUSAND);
		messageList.add("QuickSort on integers, runtime: " +
			Measurement.measureRuntime(list ->  new QuickSort<Integer>().sort(list), quickSortIntegerList));

		String[] quickSortStringList = Operations.getRandomStringList(Operations.TEN_THOUSAND);
		messageList.add("QuickSort on strings, runtime: " +
			Measurement.measureRuntime(list -> new QuickSort<String>().sort(list), quickSortStringList));

		for (String message : messageList) System.out.println(message);

	}


}