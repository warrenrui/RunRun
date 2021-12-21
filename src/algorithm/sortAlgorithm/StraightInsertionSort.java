package algorithm.sortAlgorithm;

public class StraightInsertionSort {
    public static void main(String[] args) {
        int[] array = {49, 38, 65, 97, 76, 13, 27};
        straightInsertionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void straightInsertionSort(int[] array) {
        int sentinel, j;
        for (int i = 1; i < array.length; i++) {
            j = i - 1;
            sentinel = array[i];//哨兵位
            while (j >= 0 && sentinel < array[j]) {
                array[j + 1] = array[j];//将大于sentinel的值整体后移一个单位
                j--;
            }
            array[j + 1] = sentinel;
        }
    }

    public static void straightInsertionSortOld(int[] array) {
        int guard;//哨兵位
        for (int i = 1; i < array.length; i++) {
            //默认i之前的i-1项是有序序列，若array[i]>array[i-1]，则前i项有序，继续循环。
            if (array[i] < array[i - 1]) {
                guard = array[i];
                array[i] = array[i - 1];//i项与i-1项已经比较过，不需要重复比较。i-1项后移，空出i-1项（即j+1项）
                //哨兵位与剩余的i-2位从右至左比较
                while (i - 2 >= 0) {
                    if (guard < array[i - 2]) {
                        array[i - 1] = array[i - 2];
                        --i;
                    } else {
                        //i-1位一直空着，用i-2位与哨兵位中较大的补齐
                        array[i - 1] = guard;
                        break;
                    }
                }
                //补齐特殊情况
                if (i - 1 == 0) {
                    array[i - 1] = guard;
                    continue;
                }
            }
        }
    }
}
