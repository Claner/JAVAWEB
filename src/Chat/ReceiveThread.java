package Chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Clanner on 2016/10/20.
 */
public class ReceiveThread implements Runnable {

    private DatagramSocket datagramSocket;
    private DatagramPacket datagramPacket;

    public ReceiveThread(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }

    @Override
    public void run() {
        try {
            //创建接收Socket对象
//            DatagramSocket datagramSocket = new DatagramSocket(10086);
            while (true) {
                //创建一个数据包
                byte[] bytes = new byte[1024];
                datagramPacket = new DatagramPacket(bytes, bytes.length);
                //接收数据
                datagramSocket.receive(datagramPacket);
                //解析数据
                String ip = datagramPacket.getAddress().getHostAddress();
                String s = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                System.out.println(ip + ":" + s);
            }
            //释放资源
//        datagramSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
