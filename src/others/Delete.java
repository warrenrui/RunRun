package others;

import java.util.ArrayList;

public class Delete {
    public static void main(String[] args) {
        int[] num = {-1, -10, 11, 12, -12, -13, -14, 15, -18, -19};
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i++) {
            if (num[i] > 0) {
                number.add(num[i]);
            } else {
                if (i == num.length - 1) {
                    if (i >= 1 && num[i - 1] > 0) {
                        number.add(0);
                    }
                } else if (num[i + 1] > 0) {
                    if (i == 0) {
                        number.add(0);
                    }
                    if (i >= 1 && num[i - 1] > 0) {
                        number.add(0);
                    }
                } else {
                    i++;
                }
            }
        }

        for (int j = 0; j < number.size(); j++) {
            System.out.println(number.get(j));
        }
    }
}
