package Sort;

public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

	@Override
    public void sort(T[] list) {
        for (int i = list.length; i > 1; --i) {
            for (int j = 0; j < i - 1; ++j) {
				if (list[j].compareTo(list[j + 1]) > 0) {
					swap(list, j, j + 1);
				}
            }
        }
    }

}
