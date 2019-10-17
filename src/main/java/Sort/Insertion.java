package Sort;

public class Insertion {

    public static void sort(int[] list) {
        for (int index = 1; index < list.length ; index++) {
            int value = list[index];
            int jumpIndex = index;
            while (jumpIndex > 0 && list[jumpIndex - 1] > value) {
                list[jumpIndex] = list[jumpIndex -1];
                jumpIndex--;
            }
            list[jumpIndex] = value;
        }
    }

}
