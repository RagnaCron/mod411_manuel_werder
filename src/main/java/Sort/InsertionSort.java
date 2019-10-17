package Sort;

public class InsertionSort<T extends Comparable<T>> implements Sort<T> {

    public void sort(T[] list) {
        for (int index = 1; index < list.length ; index++) {
            T value = list[index];
            int jumpIndex = index;
            while (jumpIndex > 0 && list[jumpIndex - 1].compareTo(value) > 0) {
                list[jumpIndex] = list[jumpIndex -1];
                jumpIndex--;
            }
            list[jumpIndex] = value;
        }
    }

}
