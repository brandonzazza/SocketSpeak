import java.io.*;
import java.net.*;

public class Server {
    private Socket s = null;
    private ServerSocket ss = null;
    private DataInputStream in = null;

    public Server(int port){
        try {
            ss = new ServerSocket(port);
            System.out.println("Server started, waiting for a client...");

            s = ss.accept();
            System.out.println("Client accepted");

            // Read data from client
            in = new DataInputStream(s.getInputStream());
            String received = in.readUTF();
            System.out.println("Received: " + received);

        } catch(IOException i) {
            System.out.println("Error: " + i.getMessage());
        }
    }

    public static void main(String args[]) {
        new Server(49000);
    }
}
