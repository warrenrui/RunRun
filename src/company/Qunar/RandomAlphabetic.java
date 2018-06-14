package company.Qunar;

import java.util.Random;

public class RandomAlphabetic {

    public static String randomAlphabetic(int count) {
        Random random = new Random();
        int randomNum;
        char randomChar;
        String radomStr = "";
        while (count-- != 0) {
            randomNum = random.nextInt(26);
            System.out.println("temp = " + randomNum);
            randomChar = (char) ('a' + randomNum);
            radomStr += randomChar;
        }
        return radomStr;
    }

    public static void main(String[] args) {
        System.out.println(RandomAlphabetic.randomAlphabetic(10));
    }
}
