package others;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String args[]) {
        try {
            ServerSocket serverSocket = new ServerSocket(4700);
            Socket s = serverSocket.accept();
            BufferedReader sin = new BufferedReader(new InputStreamReader(s
                    .getInputStream()));
            BufferedWriter sou = new BufferedWriter(new OutputStreamWriter(s
                    .getOutputStream()));
            sou.write("hello");
            System.out.println("11");

            System.out.println("client:" + sin.readLine());
            System.out.println("asadf ");
            sou.close();
            sin.close();
            s.close();
            System.out.println("0");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}