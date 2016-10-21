import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Clanner on 2016/10/20.
 */
public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            //通过计算机名获取ip地址对象
            InetAddress address = InetAddress.getByName("ASUS");
            //获取主机名
            String name = address.getHostName();
            //获取ip地址
            String ip = address.getHostAddress();
            System.out.println(name);
            System.out.println(ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
