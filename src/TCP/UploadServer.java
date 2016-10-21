package TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Clanner on 2016/10/21.
 */
public class UploadServer {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(10086);
        while (true){
            Socket socket = serverSocket.accept();
            new Thread(new UserThread(socket)).start();
        }
    }
}
