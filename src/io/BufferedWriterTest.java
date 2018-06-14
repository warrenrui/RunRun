package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedWriterTest {
    public static void main(String[] args) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:/java/Test/src/Test2.txt"));
            BufferedReader bufferedReader = new BufferedReader(new FileReader("d:/java/Test/src/Test2.txt"));
            String string;
            for (int i = 0; i < 100; i++) {
                string = String.valueOf(Math.random());
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            while ((string = bufferedReader.readLine()) != null) {
                System.out.println(string);
            }
            bufferedWriter.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
