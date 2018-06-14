package io;

import java.io.*;

public class OutputStreamWriterTest {
    public static void main(String[] args) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                    new FileOutputStream("d:/java/Test/src/osw.txt"));
            outputStreamWriter.write("abcdefg");
            System.out.println(outputStreamWriter.getEncoding());
            outputStreamWriter.close();

            outputStreamWriter = new OutputStreamWriter(
                    new FileOutputStream("d:/java/Test/src/osw.txt"), "ISO8859_1");
            outputStreamWriter.write("ooooooo");
            System.out.println(outputStreamWriter.getEncoding());
            outputStreamWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
