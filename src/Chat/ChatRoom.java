package Chat;

import java.io.IOException;
import java.net.DatagramSocket;

/**
 * Created by Clanner on 2016/10/20.
 */
public class ChatRoom {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocketSend = new DatagramSocket();
        DatagramSocket datagramSocketReceive = new DatagramSocket(10086);

        SendThread st = new SendThread(datagramSocketSend);
        ReceiveThread rt  = new ReceiveThread(datagramSocketReceive);

        Thread t1 = new Thread( st);
        Thread t2 = new Thread( rt);

        t1.start();
        t2.start();
    }
}
