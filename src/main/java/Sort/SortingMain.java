package Sort;

public class SortingMain {

	public static void main(String[] args) {
		Integer[] integerList1 = {12, 0, 9, 10, 4, 6, 13, 2, 8, 5, -1, 11, 1, 7, 3, 14, -2};
		BubbleSort<Integer> integerBubbleSort = new BubbleSort<Integer>();
		long startTimeIntegerBubbleSort = System.nanoTime();
		integerBubbleSort.sort(integerList1);
		long stopTimeIntegerBubbleSort = System.nanoTime();
		double milliSecondsForIntegerBubbleSort = (stopTimeIntegerBubbleSort - startTimeIntegerBubbleSort) / 1000000.0;
		System.out.println("RunTime of BubbleSort on Integers in milliseconds: " + milliSecondsForIntegerBubbleSort);
		for (int value : integerList1) System.out.print(value + " ");

		System.out.println();

		Integer[] integerList2 = {12, 0, 9, 10, 4, 6, 13, 2, 8, 5, -1, 11, 1, 7, 3, 14, -2};
		InsertionSort<Integer> integerInsertionSort = new InsertionSort<Integer>();
		long startTimeIntegerInsertionSort = System.nanoTime();
		integerInsertionSort.sort(integerList2);
		long stopTimeIntegerInsertionSort = System.nanoTime();
		double milliSecondsForIntegerInsertionSort = (stopTimeIntegerInsertionSort - startTimeIntegerInsertionSort) / 1000000.0;
		System.out.println("RunTime of InsertionSort on Integers in milliseconds: " + milliSecondsForIntegerInsertionSort);
		for (int value : integerList2) System.out.print(value + " ");

		System.out.println();

		String[] stringList1 = {"v", "p", "l", "q", "c", "g", "h", "d", "o", "x", "r", "z", "a", "t", "m", "k", "f", "y", "w", "u", "i", "b", "e", "j", "s", "n" };
		BubbleSort<String> stringBubbleSort = new BubbleSort<String>();
		long startTimeStringBubbleSort = System.nanoTime();
		stringBubbleSort.sort(stringList1);
		long stopTimeStringBubbleSort = System.nanoTime();
		double milliSecondsForStringBubbleSort = (stopTimeStringBubbleSort - startTimeStringBubbleSort) / 1000000.0;
		System.out.println("RunTime of BubbleSort on Strings in milliseconds: " + milliSecondsForStringBubbleSort);
		for (String value : stringList1) System.out.print(value + " ");

		System.out.println();

		String[] stringList2 = {"v", "p", "l", "q", "c", "g", "h", "d", "o", "x", "r", "z", "a", "t", "m", "k", "f", "y", "w", "u", "i", "b", "e", "j", "s", "n" };
		InsertionSort<String> stringInsertionSort = new InsertionSort<String>();
		long startTimeStringInsertionSort = System.nanoTime();
		stringInsertionSort.sort(stringList2);
		long stopTimeStringInsertionSort = System.nanoTime();
		double milliSecondsForStringInsertionSort = (stopTimeStringInsertionSort - startTimeStringInsertionSort) / 1000000.0;
		System.out.println("RunTime of InsertionSort on Strings in milliseconds: " + milliSecondsForStringInsertionSort);
		for (String value : stringList2) System.out.print(value + " ");

	}


}