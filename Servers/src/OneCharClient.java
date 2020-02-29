import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class OneCharClient {
    public static void main(String[] args){
        Socket s = null;
        try{
            s = new Socket("127.0.0.1",8765);
            InputStreamReader sr = new InputStreamReader(s.getInputStream());

            int c = sr.read();
            System.out.println((char)c);

            sr.close();
            s.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
