package io;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SystemIn {
    public static void main(String[] args) {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            String string = bufferedReader.readLine();
            while (string != null) {
                if (string.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println(string.toUpperCase());
                string = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
