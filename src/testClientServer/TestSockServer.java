package testClientServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class TestSockServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5888);
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            String string = null;
            if ((string = dataInputStream.readUTF()) != null) {
                System.out.println(string);
                System.out.println("from: " + socket.getInetAddress());
                System.out.println("port: " + socket.getPort());
            }
            dataOutputStream.writeUTF("hello client");
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
