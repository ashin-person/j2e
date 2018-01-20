package ljx.ashin.io.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by AshinLiang on 2017/8/22.
 */
public class BioClient {

    private static String ip = "127.0.0.1";//IP地址
    private static int port = 1234;

    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        PrintWriter printWriter = null;

        try {
            socket = new Socket(ip,port);
            outputStream = socket.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream);
//            outputStreamWriter.write("client msg",0,"client msg".length());
            printWriter = new PrintWriter(outputStream,true);
            printWriter.println("client msg");



        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
