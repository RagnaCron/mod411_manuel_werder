package Sort;

public class InsertionSort<T extends Comparable<T>> implements Sort<T> {

//    @Override
//    public void sort(T[] list) {
//        for (int i = 1; i < list.length ; i++) {
//            T temp = list[i];
//            int j = i;
//            while (j > 0 && list[j - 1].compareTo(temp) > 0) {
//                list[j] = list[j -1];
//                j--;
//            }
//            list[j] = temp;
//        }
//    }

    @Override
    public void sort(T[] list) {
        for (int i = 1; i < list.length ; i++) {
            T temp = list[i];
            int j;
            for (j = i; j > 0 && list[j-1].compareTo(temp) > 0; j--) {
                list[j] = list[j-1];
            }
            list[j] = temp;
        }
    }

}
