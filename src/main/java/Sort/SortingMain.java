package Sort;

public class SortingMain {

	public static void main(String[] args) {
		Integer[] list1 = {0, 9, 4, 6, 2, 8, 5, 1, 7, 3};
		BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();
		bubbleSort.sort(list1);
		for (int value : list1) System.out.print(value + " ");

		System.out.println();

		Integer[] list2 = {0, 9, 4, 6, 2, 8, 5, 1, 7, 3};
		InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();
		insertionSort.sort(list2);
		for (int value : list2) System.out.print(value + " ");
	}


}
