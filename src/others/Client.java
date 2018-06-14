package others;

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String args[]) {
        try {
            Socket socket = new Socket("127.0.0.1", 4700);
            BufferedReader cin = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            BufferedWriter cou = new BufferedWriter(new OutputStreamWriter(
                    socket.getOutputStream()));
            cou.write("hello.java");
            cou.flush();

            System.out.println("server:" + cin.readLine());
            System.out.println("222");
            cou.close();
            cin.close();
            socket.close();
            System.out.println("0");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}