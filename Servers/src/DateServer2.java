import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer2 {
    private static int PORT = 8765;
    private static ServerSocket listener;

    public static void main(String[] args){
        try{
            listener = new ServerSocket(PORT);
            while(true){
                new Handler(listener.accept()).start();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                listener.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket){
            this.socket = socket;
        }

        public void run(){
            try{
                System.out.println("New connection started on thread " + this.getName());
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Hello - welcome to the date server, You're on thread " + this.getName());
                while(true){
                    String message = (new Date().toString());
                    out.println(message);
                    Thread.sleep(500);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally{
                try{
                    this.socket.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
