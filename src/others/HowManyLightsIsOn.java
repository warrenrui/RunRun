package others;

/**
 * 150盏亮着的电灯，各有一个拉线开关控制，被顺序编号为1，2,3,4，…，150。 将编号为3的倍数的灯的拉线各拉一下，再将编号为5的倍数的拉线各拉一下，
 * 拉完后亮着的灯数为几盏？
 */
public class HowManyLightsIsOn {
    public static void main(String[] args) {
        boolean[] lights = new boolean[151];
        int count = 0;
        for (int i = 1; i < lights.length; i++) {
            lights[i] = true;
            if (i % 3 == 0) {
                lights[i] = !lights[i];
            }
            if (i % 5 == 0) {
                lights[i] = !lights[i];
            }
            if (lights[i]) {
                count++;
            }
            System.out.println(i + " -- " + lights[i] + " -- " + count);
        }
    }
}
