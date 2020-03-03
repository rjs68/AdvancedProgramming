import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BankServer {
    public static void main(String[] args){
        final int ACCOUNTS_LENGTH = 10;
        Bank bank = new Bank(ACCOUNTS_LENGTH);
        final int SBAP_PORT = 8888;
        try{
            ServerSocket server = new ServerSocket(SBAP_PORT);
            System.out.println("Waiting for clients to connect...");
            while(true){
                Socket s = server.accept();
                System.out.println("Client connected.");
                BankService service = new BankService(s, bank);
                Thread t = new Thread(service);
                t.start();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
