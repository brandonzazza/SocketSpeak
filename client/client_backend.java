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
}
