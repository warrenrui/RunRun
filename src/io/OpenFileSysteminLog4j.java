package io;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;

public class OpenFileSysteminLog4j {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            FileWriter fileWriter = new FileWriter("d:/java/log.log", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                if (string.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println(string.toUpperCase());
                printWriter.println("-------");
                printWriter.write(string.toUpperCase());
                printWriter.println();
                printWriter.flush();
            }
            printWriter.println("=======" + new Date(System.currentTimeMillis()) + "======");
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}