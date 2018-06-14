package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;


public class DataStreamTest {
    public static void main(String[] args) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeDouble(Math.random());
            dataOutputStream.writeBoolean(true);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
                    byteArrayOutputStream.toByteArray());
            System.out.println(byteArrayInputStream.available());
            DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);

            System.out.println(dataInputStream.readDouble());
            System.out.println(dataInputStream.readBoolean());

            dataOutputStream.close();
            dataInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
