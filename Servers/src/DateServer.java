import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {
    private static int PORT = 8765;
    private static Socket client;
    private static ServerSocket listener;

    public static void main(String args[]){
        try{
            listener = new ServerSocket(PORT);
            client = listener.accept();
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            while(true){
                out.println((new Date()).toString());
                Thread.sleep(500);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                client.close();
                listener.close();
            }catch(Exception e){}
        }
    }
}
