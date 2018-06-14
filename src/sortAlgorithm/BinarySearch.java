package sortAlgorithm;

public class BinarySearch {
    public static void main(String[] args) {
        int a[] = {1, 3, 6, 8, 9, 10, 12, 18, 20, 34};
        int i = 12;
        System.out.println(binarySearch(a, i));
    }

    public static int binarySearch(int[] a, int num) {
        if (a.length == 0) {
            return -1;
        }
        int startPosition = 0;
        int endPosition = a.length - 1;
        int midPosition = (startPosition + endPosition) / 2;
        while (startPosition <= endPosition) {
            if (a[midPosition] == num) {
                return midPosition;
            }
            if (a[midPosition] > num) {
                endPosition = midPosition - 1;
            }
            if (a[midPosition] < num) {
                startPosition = midPosition + 1;
            }
            midPosition = (startPosition + endPosition) / 2;
        }
        return -1;
    }
}
