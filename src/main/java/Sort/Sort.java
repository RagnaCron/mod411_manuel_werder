package Sort;

@FunctionalInterface
public interface Sort<T extends Comparable<T>> {

	void sort(T[] list);

	default void swap(T[] list, int leftSide, int rightSide) {
		T temp = list[leftSide];
		list[leftSide] = list[rightSide];
		list[rightSide] = temp;
	}

	default void medianOfThree(T[] list, int leftSide, int rightSide) {
		if (rightSide - leftSide > 3) {
			int middle = (leftSide + rightSide) / 2;
			if (list[leftSide].compareTo(list[middle]) > 0) swap(list, leftSide, middle);
			if (list[leftSide].compareTo(list[rightSide]) > 0) swap(list, leftSide, rightSide);
			else if (list[rightSide].compareTo(list[middle]) > 0) swap(list, rightSide, middle);
		}
	}

}
