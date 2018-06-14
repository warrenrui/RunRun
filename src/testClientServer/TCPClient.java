package testClientServer;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 6666);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        String string = "hello server!";
        dataOutputStream.writeUTF(string);
        dataOutputStream.flush();
        dataOutputStream.close();
        outputStream.close();
        socket.close();
    }
}
