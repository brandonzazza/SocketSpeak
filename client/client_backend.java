import java.io.*;
import java.net.*;

public class client_backend {

    private Socket s = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;

    // private String sanitize(String s) {
        
    // }

    public boolean connect(String ip, String password) {
        // Stringsanitize()

        int PORT = 49000;
        try {
            s = new Socket(ip, PORT);
            in = new DataInputStream(System.in);
            out = new DataOutputStream(s.getOutputStream());
        } catch (UnknownHostException u) {
            System.out.println(u);
            return false;
        }
        catch (IOException i) {
            System.out.println(i);
            return false;
        }
        return true;
    }

    public boolean disconnect() {
        try {
            in.close();
            out.close();
            s.close();
            return true;
        }
        catch (IOException i) {
            System.out.println(i);
            return false;
        }
    }

    public static void main(String[] args) {

        client_backend cli = new client_backend();
        cli.connect("127.0.0.1", "Password");
        try {
            System.out.println("Waiting for 5 seconds before disconnecting...");
            Thread.sleep(5000);  // Wait for 5 seconds (5000 milliseconds)
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted: " + e.getMessage());
        }
        cli.disconnect();

    }
}
