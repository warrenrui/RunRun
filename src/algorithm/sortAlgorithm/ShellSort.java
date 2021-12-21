package algorithm.sortAlgorithm;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
        shellSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void shellSort(int[] array) {
        double increment = array.length;//增量长度
        int dk, sentinel, k;
        while (true) {
            increment = Math.ceil(increment / 2);//逐渐减小增量长度
            dk = (int) increment;//确定增量长度
            for (int i = 0; i < dk; i++) {
                //用增量将序列分割，分别进行直接插入排序。随着增量变小为1，最后整体进行直接插入排序
                for (int j = i + dk; j < array.length; j += dk) {
                    k = j - dk;
                    sentinel = array[j];//哨兵位
                    while (k >= 0 && sentinel < array[k]) {
                        array[k + dk] = array[k];//k+dk位始终虚位以待
                        k = k - dk;
                    }
                    array[k + dk] = sentinel;
                }
            }
            //当dk为1的时候，整体进行直接插入排序
            if (dk == 1) {
                break;
            }
        }
    }
}
