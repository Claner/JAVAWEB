package TCP;

import java.io.*;
import java.net.Socket;

/**
 * Created by Clanner on 2016/10/21.
 */
public class UserThread implements Runnable{

    private Socket socket;

    public UserThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String name = System.currentTimeMillis()+".txt";
            BufferedWriter bw = new BufferedWriter(new FileWriter(name));
            String line = null;
            while ((line = br.readLine())!= null){
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
            BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bwServer.write("文件上传成功");
            bwServer.newLine();
            bwServer.flush();

            bw.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
