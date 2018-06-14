package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;


public class BufferedInputStreamMark {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("d:/java/Test/src/Test.java");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
//			System.out.println((char)bufferedInputStream.read());
//			System.out.println((char)bufferedInputStream.read());
            int c;

            bufferedInputStream.mark(100);
            for (int i = 0; i < 10 && ((c = bufferedInputStream.read()) != -1); i++) {
                System.out.print((char) c);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
