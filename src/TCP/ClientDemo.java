package TCP;

import java.io.*;
import java.net.Socket;

/**
 * Created by Clanner on 2016/10/20.
 * 客户端
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //创建发送端的Socket对象
        Socket socket = new Socket("ASUS", 10086);
        //键盘录入数据
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //读文本文件
        BufferedReader br = new BufferedReader(new FileReader("a.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String line = null;
        while ((line = br.readLine()) !=null){
            if (line.equals("stop")) break;
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        //Socket提供了一个终止功能
        socket.shutdownOutput();
        //获取输出流，写数据
//        OutputStream os = socket.getOutputStream();
//        os.write("Hello,tcp我来了".getBytes());
        //接收服务器返回的数据
        byte[] bytes = new byte[1024];
        String str = new String(bytes, 0, socket.getInputStream().read(bytes));
        System.out.println(str);
        //释放资源
//        bw.close();
//        br.close();
        socket.close();
    }
}
