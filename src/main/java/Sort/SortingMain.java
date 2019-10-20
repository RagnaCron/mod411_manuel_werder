package Sort;

import java.util.Random;
import java.util.function.Consumer;

public class SortingMain {

	private final static String[] ABC_LIST = {
			"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
			"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
	};

	private static String[] getRandomStringList(int size) {
		Random rand = new Random();
		String[] list = new String[size];
		for (int i = 0; i < size; i++) list[i] = ABC_LIST[rand.nextInt(ABC_LIST.length)];
		return list;
	}

	private static int[] getRandomIntList(int size) {
		Random rand = new Random();
		int[] list = new int[size];
		for (int i = 0; i < size; i++) list[i] = rand.nextInt();
		return list;
	}

	private static <T> void measureRuntime(T[] list, String sortingName, String typeName, Consumer<T[]> sorter) {
		long startTime = System.nanoTime();
		sorter.accept(list);
		long stopTime = System.nanoTime();
		double milliseconds = (stopTime - startTime) / 1000000.0;
		System.out.println("Runtime of " + sortingName + " on " + typeName + " in milliseconds: " + milliseconds);
		for (T value : list) System.out.print(value + " ");
	}

	public static void main(String[] args) {
		System.out.println();

		Integer[] integerList1 = {12, 0, 9, 10, 4, 6, 13, 2, 8, 5, -1, 11, 1, 7, 3, 14, -2};
		measureRuntime(integerList1, "BubbleSort", "Integer", list -> new BubbleSort<Integer>().sort(list));

		System.out.println();

		String[] stringList1 = getRandomStringList(100);
		measureRuntime(stringList1, "BubbleSort", "String", list -> new BubbleSort<String>().sort(list));

		System.out.println("\n");

		Integer[] integerList2 = {12, 0, 9, 10, 4, 6, 13, 2, 8, 5, -1, 11, 1, 7, 3, 14, -2};
		measureRuntime(integerList2, "InsertionSort", "Integer", list ->  new InsertionSort<Integer>().sort(list));

		System.out.println();

		String[] stringList2 = getRandomStringList(100);
		measureRuntime(stringList2, "InsertionSort", "String", list -> new InsertionSort<String>().sort(list));

		System.out.println("\n");

		Integer[] integerList3 = {12, 0, 9, 10, 4, 6, 13, 2, 8, 5, -1, 11, 1, 7, 3, 14, -2};
		measureRuntime(integerList3, "QuickSort", "Integer", list ->  new QuickSort<Integer>().sort(list));

		System.out.println();

		String[] stringList3 = getRandomStringList(100);
		measureRuntime(stringList3, "QuickSort", "String", list -> new QuickSort<String>().sort(list));

	}

}