package others;

import java.util.ArrayList;

//连续两个以上的负数去除，单个负数归零，正数不变
public class Delete1 {
    public static void main(String[] args) {
        int[] num = {1, -10, 11, 12, -12, 1, -14, 15, 18, -19};
        Delete1 delete1 = new Delete1();
        ArrayList<Integer> arrayList = delete1.delete(num);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }

    ArrayList<Integer> delete(int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                arrayList.add(array[i]);
            } else {
                // 需要考虑第一位和最后以为特殊，所以要首先检测后一位的情况
                if (i == array.length - 1) {
                    if (i >= 1 && array[i - 1] > 0) {
                        arrayList.add(0);
                    }
                } else {
                    if (array[i + 1] > 0) {
                        if (i == 0) {
                            arrayList.add(0);
                        }
                        if (i >= 1 && array[i - 1] > 0) {
                            arrayList.add(0);
                        }
                    } else {
                        i++;
                    }
                }
            }
        }
        return arrayList;
    }
}
