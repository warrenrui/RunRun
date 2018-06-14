package testClientServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class TestSockClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5888);
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            dataOutputStream.writeUTF("hi, server!");
            String str = null;
            if ((str = dataInputStream.readUTF()) != null) {
                System.out.println(str);
            }
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
