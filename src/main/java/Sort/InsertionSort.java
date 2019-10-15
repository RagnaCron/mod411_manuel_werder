package Sort;

public class InsertionSort {

    private static void insertionsort(int[] liste) {
        for (int index = 1; index < liste.length ; index++) {
            int value = liste[index];
            int jumpIndex = index;
            while (jumpIndex > 0 && liste[jumpIndex - 1] > value) {
                liste[jumpIndex] = liste[jumpIndex -1];
                jumpIndex--;
            }
            liste[jumpIndex] = value;
        }
    }

    public static void main(String[] args) {
        int[] liste = {0, 9, 4, 6, 2, 8, 5, 1, 7, 3};
        insertionsort(liste);
        for (int value : liste)
            System.out.print(value + " ");
    }

}
