package Sort;

public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

	@Override
    public void sort(T[] list) {
        for (int index = list.length; index > 1; --index) {
            for (int i = 0; i < index - 1; ++i) {
				if (list[i].compareTo(list[i + 1]) > 0) {
					T value = list[i];
					list[i] = list[i + 1];
					list[i + 1] = value;
				}
            }
        }
    }

}
