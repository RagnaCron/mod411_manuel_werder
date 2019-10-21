package Sort;

import TimeMeasurement.OperationMeasurement;
import TimeMeasurement.Operations;
import java.util.ArrayList;

public class SortingMain {



	public static void main(String[] args) {
		ArrayList<String> messageList = new ArrayList<>();

		Integer[] bubbleSortIntegerList = Operations.getRandomIntegerList(Operations.THOUSAND);
		messageList.add("BubbleSort on integers, " +
			OperationMeasurement.measureRuntime(list -> new BubbleSort<Integer>().sort(list), bubbleSortIntegerList));

		String[] bubbleSortStringList = Operations.getRandomStringList(Operations.THOUSAND);
		messageList.add("BubbleSort on strings, " +
			OperationMeasurement.measureRuntime(list -> new BubbleSort<String>().sort(list), bubbleSortStringList));

		Integer[] insertionSortIntegerList = Operations.getRandomIntegerList(Operations.THOUSAND);
		messageList.add("InsertionSort on integers, " +
			OperationMeasurement.measureRuntime(list ->  new InsertionSort<Integer>().sort(list), insertionSortIntegerList));

		String[] insertionSortStringList = Operations.getRandomStringList(Operations.THOUSAND);
		messageList.add("InsertionSort on strings, " +
			OperationMeasurement.measureRuntime(list -> new InsertionSort<String>().sort(list), insertionSortStringList));

		Integer[] quickSortIntegerList = Operations.getRandomIntegerList(Operations.TEN_THOUSAND);
		messageList.add("QuickSort on integers, " +
			OperationMeasurement.measureRuntime(list ->  new QuickSort<Integer>().sort(list), quickSortIntegerList));

		String[] quickSortStringList = Operations.getRandomStringList(Operations.TEN_THOUSAND);
		messageList.add("QuickSort on strings, " +
			OperationMeasurement.measureRuntime(list -> new QuickSort<String>().sort(list), quickSortStringList));

		for (String message : messageList) System.out.println(message);

	}


}