package Sort;

public class Bubble {

    public void sort(int[] list) {
        for (int index = list.length; index > 1; --index) {
            for (int i = 0; i < index - 1; ++i) {
                if (list[i] > list[i + 1]) {
                    int value = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = value;
                }
            }
        }
    }

}
