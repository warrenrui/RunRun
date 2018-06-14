package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;


public class OpenFileSystemin {
    public static void main(String[] args) {
        String fileName = args[0];
        if (fileName != null) {
            List(fileName, System.out);
        }
    }

    public static void List(String fileName, PrintStream printStream) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                printStream.println(string);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("有错");
            e.printStackTrace();
        }
    }
}