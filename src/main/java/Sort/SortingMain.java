package Sort;

public class SortingMain {

	private static <T> void measureRuntime(T[] list, String sortingName, String typeName, Sort<T> sorter) {
		long startTime = System.nanoTime();
		sorter.sort(list);
		long stopTime = System.nanoTime();
		double milliseconds = (stopTime - startTime) / 1000000.0;
		System.out.println("Runtime of " + sortingName + " on " + typeName + " in milliseconds: " + milliseconds);
		for (T value : list) System.out.print(value + " ");
	}

	public static void main(String[] args) {

		Integer[] integerList1 = {12, 0, 9, 10, 4, 6, 13, 2, 8, 5, -1, 11, 1, 7, 3, 14, -2};
		measureRuntime(integerList1, "BubbleSort", "Integer", new BubbleSort<Integer>());

		System.out.println();

		Integer[] integerList2 = {12, 0, 9, 10, 4, 6, 13, 2, 8, 5, -1, 11, 1, 7, 3, 14, -2};
		measureRuntime(integerList2, "InsertionSort", "Integer", new InsertionSort<Integer>());

		System.out.println();

		String[] stringList1 = {"v", "p", "l", "q", "c", "g", "h", "d", "o", "x", "r", "z", "a", "t", "m", "k", "f", "y", "w", "u", "i", "b", "e", "j", "s", "n"};
		measureRuntime(stringList1, "BubbleSort", "String", new BubbleSort<String>());

		System.out.println();

		String[] stringList2 = {"v", "p", "l", "q", "c", "g", "h", "d", "o", "x", "r", "z", "a", "t", "m", "k", "f", "y", "w", "u", "i", "b", "e", "j", "s", "n"};
		measureRuntime(stringList2, "InsertionSort", "String", new InsertionSort<String>());

	}

}