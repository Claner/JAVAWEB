package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Clanner on 2016/10/20.
 * 模拟UDP接收数据
 */
public class Receive {
    public static void main(String[] args) throws IOException {
        //创建接收Socket对象
        DatagramSocket datagramSocket = new DatagramSocket(10086);
        while (true) {
            //创建一个数据包
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            //接收数据
            datagramSocket.receive(datagramPacket);
            //解析数据
            String ip = datagramPacket.getAddress().getHostAddress();
            String s = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println(ip + ":" + s);
        }
        //释放资源
//        datagramSocket.close();
    }
}

