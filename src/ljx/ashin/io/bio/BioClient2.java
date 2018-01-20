package ljx.ashin.io.bio;

import java.io.*;
import java.net.Socket;

/**bio的传统做法
 * Created by AshinLiang on 2017/8/23.
 */
public class BioClient2 {

    private static final String ip = "127.0.0.1";
    private static final int port = 1234;

    public static void main(String[] args) {
        Socket socket = null;
        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader = null;

        try {
            socket = new Socket(ip,port);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("client msg to server\\n");
            bufferedWriter.flush();

            /*PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
            printWriter.println("tsetwfeoijcoewjfcoiew");*/

            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverMsg = bufferedReader.readLine();
            System.out.println(serverMsg);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
