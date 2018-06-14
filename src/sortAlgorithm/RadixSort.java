package sortAlgorithm;

public class RadixSort {
    public static void sort(int[] number, int d) {
        int k = 0;
//		控制数字所在分位数
        int n = 1;
//		
        int m = 1;
//		临时数组，数据每个位数上的数字对应该数据
        int[][] temp = new int[number.length][number.length];
//		对于相同的数字，第几次出现
        int[] order = new int[number.length];
//		d是基数
        while (m <= d) {

            for (int i = 0; i < number.length; i++) {
//				求出最低位数字
                int lsd = ((number[i] / n) % 10);
//				记录
                temp[lsd][order[lsd]] = number[i];
                System.out.println(lsd + " to " + order[lsd] + " " + number[i]);
//				若出现相同的数字，则注明出现的次序
                order[lsd]++;
            }
            System.out.println("-----------------------------");
            for (int i = 0; i < d; i++) {
                if (order[i] != 0)
                    for (int j = 0; j < order[i]; j++) {
                        number[k] = temp[i][j];
                        k++;
                    }
                order[i] = 0;
            }
//			由低到高，依次处理对应数字
            n *= 10;
//			临时变量
            k = 0;
//			计数
            m++;
        }
    }

    public static void main(String[] args) {
//		用该数组测试数组下标越界
//		int[] data = { 73, 22, 93, 43, 55, 14};
        int[] data = {73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100};
        sort(data, 10);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }
}