package Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Clanner on 2016/10/20.
 */
public class SendThread implements Runnable {

    private DatagramSocket datagramSocket;
    private DatagramPacket datagramPacket;

    public SendThread(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }

    @Override
    public void run() {
        try {
            //创建Socket对象
//            DatagramSocket datagramSocket = new DatagramSocket();
            //封装键盘录入数据
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.equals("886")) break;
                //创建数据并把数据打包
                byte[] bytes = line.getBytes();
                datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("ASUS"), 10086);
                //调用Socket对象的发送方法发送数据包
                datagramSocket.send(datagramPacket);
                System.out.println("发送数据成功，请注意查收");
            }
            //释放资源
            datagramSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
