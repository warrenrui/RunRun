package testClientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class TalkClient {
    public static void main(String[] args) {
        try {
//			设置客户端socket，需要服务器的IP地址和端口号
            Socket socket = new Socket("127.0.0.1", 4567);
//			新建一个连接，接受系统输入System.in 的数据，外面包上InputStreamReader、BufferedReader
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
//			新建一个连接，接受服务器端传来的数据
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			客户端输出的数据
            PrintWriter os = new PrintWriter(socket.getOutputStream());
//			阻塞式等待读取System.in传来的数据
            String string = sin.readLine();
            while (!(string.equals("bye"))) {
//				os.println(string);
//				os.flush();
                System.out.println("Client: " + string);
                System.out.println("Server: " + is.readLine());
                string = sin.readLine();
            }
            os.close();
            is.close();
            sin.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
