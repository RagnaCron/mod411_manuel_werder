package Sort;

public class SortingMain {

	public static void main(String[] args) {
		int[] list1 = {0, 9, 4, 6, 2, 8, 5, 1, 7, 3};
		Bubble bubble = new Bubble();
		bubble.sort(list1);
		for (int value : list1) System.out.print(value + " ");

		System.out.println();

		int[] list2 = {0, 9, 4, 6, 2, 8, 5, 1, 7, 3};
		Insertion.sort(list2);
		for (int value : list2) System.out.print(value + " ");
	}


}
