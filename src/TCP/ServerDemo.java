package TCP;

import com.sun.xml.internal.stream.buffer.XMLStreamBufferResult;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Clanner on 2016/10/20.
 * 服务器端
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException{
        //监听客户端连接，返回一个对应的Socket对象
        Socket socket = new ServerSocket(10086).accept();
        //获取键盘录入的数据
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new FileWriter("b.txt"));
        String line = null;
        while ((line = br.readLine())!=null){
            //控制台输出
            System.out.println(line);
            //写入文件(若客户端发送过来的是文件，相当于复制)
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        //获取输入流，读取数据
//        InputStream is = socket.getInputStream();
//        byte[] bytes = new byte[1024];
//        int len = is.read(bytes);
//        String str = new String(bytes,0,len);
//        System.out.println(str);
//        //返回数据（如接收成功）
        socket.getOutputStream().write("服务器端接收到数据".getBytes());
        //释放资源
        bw.close();
        socket.close();
    }
}
