package Sort;

@FunctionalInterface
public interface Sort<T extends Comparable<T>> {

	void sort(T[] list);

	default void swap(T[] list, int leftSide, int rightSide) {
		T temp = list[leftSide];
		list[leftSide] = list[rightSide];
		list[rightSide] = temp;
	}

}
