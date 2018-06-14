package testClientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class TalkServer {
    public static void main(String[] args) {
        try {
//			新建一个服务器端口，端口号4567
            ServerSocket serverSocket = new ServerSocket(4567);
//			阻塞式等待新的客户端连接，一直等到有连接才终止
            Socket socket = serverSocket.accept();
//			新建一个连接，接受客户端传来的数据
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			服务器端输出的数据
            PrintWriter os = new PrintWriter(socket.getOutputStream());
//			新建连接，接受系统输入System.in的数据
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
//			阻塞式等待接受客户端发来的数据，并打印出
            System.out.println("Client: " + is.readLine());
//			阻塞式等待接受系统输入System.in的数据，并打印出
            String string = sin.readLine();
            while (!(string.equals("bye"))) {
//				os.println(string);
//				os.flush();
                System.out.println("Server: " + string);
                System.out.println("Client: " + is.readLine());
                string = sin.readLine();
            }
            is.close();
            sin.close();
            os.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
