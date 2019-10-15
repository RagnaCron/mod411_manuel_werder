package Sort;

public class BubbleSort {

    private static void bubbleSort(int[] liste) {
        for (int index = liste.length; index > 1; --index) {
            for (int i = 0; i < index - 1; ++i) {
                if (liste[i] > liste[i + 1]) {
                    int value = liste[i];
                    liste[i] = liste[i + 1];
                    liste[i + 1] = value;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] liste = {0, 9, 4, 6, 2, 8, 5, 1, 7, 3};
        bubbleSort(liste);
        for (int value : liste) System.out.print(value + " ");
    }

}
