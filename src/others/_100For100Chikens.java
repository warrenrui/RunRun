package others;

public class _100For100Chikens {
    /**
     * 我国古代数学家张丘建在《算经》一书中曾提出过著名的“百钱买百鸡”问题。
     * 该问题叙述如下：鸡翁一，值钱五；鸡母一，值钱三；鸡雏三，值钱一；百钱买百鸡， 则翁，母，雏各几何？
     *
     * @param i
     * @param j
     * @param k
     * @return
     */
    public static boolean accord(int i, int j, int k) {
        if (5 * i + 3 * j + k / 3 == 100 && k % 3 == 0 && i + j + k == 100)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        int i, j, k;
        System.out.println("the possible plans for buying 100 fowls with 100 yuan are:\n");
        for (i = 0; i < 21; i++)
            for (j = 0; j < 34; j++)
                for (k = 0; k < 101; k++)
                    if (accord(i, j, k))
                        System.out.println("公鸡、母鸡、小鸡个数：  " + i + "  " + j + "  " + k);
    }
}
