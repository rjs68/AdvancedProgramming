import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket s = null;
        try {
            s = new Socket("127.0.0.1", 8765);
            Scanner sr = new Scanner(s.getInputStream());
            while(sr.hasNextLine()){
                System.out.println(sr.nextLine());
            }
            sr.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
