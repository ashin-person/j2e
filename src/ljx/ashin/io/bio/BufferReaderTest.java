package ljx.ashin.io.bio;

import java.io.*;

/**
 * Created by AshinLiang on 2017/8/23.
 */
public class BufferReaderTest {

    public static void main(String[] args) {

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\a.txt")) );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
     /*       String string = bufferedReader.readLine();

            System.out.println(string);*/

            bufferedWriter.write("dsjfoiwejfoiwejfoeiwjf");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
