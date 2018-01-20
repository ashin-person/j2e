package ljx.ashin.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by AshinLiang on 2017/8/22.
 */
public class BioServer {

    private static int port = 1234;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try {
            serverSocket = new ServerSocket(port);
            //获取客户端传过来的socket
            Socket socket = serverSocket.accept();
            //读取socket的内容
            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);

            String clientContent = null;
            while (true){
                clientContent = bufferedReader.readLine();
                if (clientContent ==null){
                    break;
                }
                System.out.println("接收客户端传送过来的信息："+clientContent);

            }

           /* char cha[] = new char[1024];
            int len = inputStreamReader.read(cha);
            String content = new String(cha,0,len);
            System.out.println(content);*/

        }catch (Exception e){
            e.printStackTrace();
        }finally {

            if (inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inputStreamReader!=null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
