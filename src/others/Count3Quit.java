package others;

public class Count3Quit {
    public static void main(String[] args) {
        boolean[] arr = new boolean[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = true;
        }

        int leftCount = arr.length;        //圈中剩余的人数
        int numCount = 0;                //当前数的数目1、2、3
        int index = 0;                    //当前人所在的序列

        while (leftCount > 1) {
            if (arr[index] == true) {
                numCount++;
                if (numCount == 3) {
                    numCount = 0;
                    arr[index] = false;
                    leftCount--;
                }
            }

            index++;

            if (index == arr.length) {
                index = 0;
            }
            System.out.println(leftCount + "@");
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == true) {
                System.out.println(i);
            }
        }
    }
}
