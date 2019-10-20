package Sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

	@Test
	void quickSortStringTest() {
		QuickSort<String> stringQuickSort = new QuickSort<String>();
		String[] list = {"q", "c", "h", "d", "p", "x"};
		String[] expectedList = {"c", "d", "h", "p", "q", "x"};
		stringQuickSort.sort(list);
		assertArrayEquals(expectedList, list);
	}

	@Test
	void quickSortIntegerTest() {
		QuickSort<Integer> integerQuickSort = new QuickSort<Integer>();
		Integer[] list = {5, 8, 3, 6, 1, 9, 2, 7, 4, 0};
		Integer[] expectedList = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		integerQuickSort.sort(list);
		assertArrayEquals(expectedList, list);
	}
}