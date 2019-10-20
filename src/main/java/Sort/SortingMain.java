package Sort;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

public class SortingMain {

	private final static String[] ABC_LIST = {
			"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
			"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
			"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
			"n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
			"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "<", ".", ":",
			",", ";", "-", "_", "{", "}", "[", "]", "+", "¦", "@", "*", "#",
			"%", "&", "°", "¬", "/", "|", "(", "¢", ")", "=", "'", "?", "´",
			"^", "`", "~", "!", "¨", "$", "£", ">", "\\"
	};

	private static String[] getRandomStringList(int size) {
		Random rand = new Random();
		String[] list = new String[size];
		for (int i = 0; i < size; i++)
			list[i] = ABC_LIST[rand.nextInt(ABC_LIST.length)];
		return list;
	}

	private static String[] getRandomIntegerStringList(int size) {
		Random rand = new Random();
		String[] list = new String[size];
		for (int i = 0; i < size; i++)
			list[i] = String.valueOf(rand.nextLong());
		return list;
	}

	private static Integer[] getRandomIntegerList(int size) {
		Random rand = new Random();
		Integer[] list = new Integer[size];
		for (int i = 0; i < size; i++)
			list[i] = rand.nextInt();
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

		Integer[] bubbleSortIntegerList = getRandomIntegerList(10000);
		measureRuntime(bubbleSortIntegerList, "BubbleSort", "Integer", list -> new BubbleSort<Integer>().sort(list));

		System.out.println("\n");

		String[] bubbleSortStringList = getRandomStringList(10000);
		measureRuntime(bubbleSortStringList, "BubbleSort", "String", list -> new BubbleSort<String>().sort(list));

		System.out.println("\n");

		Integer[] insertionSortIntegerList = getRandomIntegerList(10000);
		measureRuntime(insertionSortIntegerList, "InsertionSort", "Integer", list ->  new InsertionSort<Integer>().sort(list));

		System.out.println("\n");

		String[] insertionSortStringList = getRandomStringList(10000);
		measureRuntime(insertionSortStringList, "InsertionSort", "String", list -> new InsertionSort<String>().sort(list));

		System.out.println("\n");

		Integer[] quickSortIntegerList = getRandomIntegerList(10000);
		measureRuntime(quickSortIntegerList, "QuickSort", "Integer", list ->  new QuickSort<Integer>().sort(list));

		System.out.println("\n");

		String[] quickSortIntegerStringList = getRandomIntegerStringList(10000);
		measureRuntime(quickSortIntegerStringList, "QuickSort", "String", list -> new QuickSort<String>().sort(list));

		System.out.println("\n");

		String[] quickSortStringList = getRandomStringList(10000);
		measureRuntime(quickSortStringList, "QuickSort", "String", list -> new QuickSort<String>().sort(list));

	}

}