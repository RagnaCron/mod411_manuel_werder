package Sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

	private BubbleSort<String> stringBubbleSort = new BubbleSort<String>();
	private BubbleSort<Integer> integerBubbleSort = new BubbleSort<Integer>();

	@Test
	void bubbleSortStringTest() {
		String[] list = {"q", "c", "h", "d", "p", "x"};
		String[] expectedList = {"c", "d", "h", "p", "q", "x"};
		stringBubbleSort.sort(list);
		assertArrayEquals(expectedList, list);
	}

	@Test
	void bubbleSortIntegerTest() {
		Integer[] list = {5, 8, 3, 6, 1, 9, 2, 7, 4, 0};
		Integer[] expectedList = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		integerBubbleSort.sort(list);
		assertArrayEquals(expectedList, list);
	}
}