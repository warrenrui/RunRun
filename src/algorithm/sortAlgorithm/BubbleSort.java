package algorithm.sortAlgorithm;

public class BubbleSort {
    public static void main(String[] args) {
        int array[] = {5, 6, 8, 4, 2, 4, 9, 0};
        bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void bubbleSort(int array[]) {
        int temp;
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
