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

            while(true){
                s = ss.accept();
                System.out.println("Client accepted");

                new ClientHandler(s).start();
            }
            

        } catch(IOException i) {
            System.out.println("Error: " + i.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private Socket s;
        private DataInputStream in;
        private DataOutputStream out;

        public ClientHandler(Socket socket) {
            this.s = socket;
        }

        public void run() {
            try {
                // Initialize input/output streams for this client
                in = new DataInputStream(s.getInputStream());
                out = new DataOutputStream(s.getOutputStream());

                String received;
                // Handle client communication
                while (true) {
                    received = in.readUTF();  // Read data sent by the client

                    // If the client sends "exit", gracefully close the connection
                    if (received.equalsIgnoreCase("exit")) {
                        System.out.println("Client disconnected: " + s.getInetAddress().getHostAddress());
                        break;
                    }

                    System.out.println("Received from client: " + received);

                    // Respond to client
                    out.writeUTF("Server received: " + received);
                }

            } catch (IOException i) {
                System.out.println("Error: " + i.getMessage());
            } finally {
                // Close resources
                try {
                    if (in != null) in.close();
                    if (out != null) out.close();
                    if (s != null) s.close();
                    System.out.println("Client resources closed.");
                } catch (IOException e) {
                    System.out.println("Error closing resources: " + e.getMessage());
                }
            }
        }
    }

    public static void main(String args[]) {
        new Server(49000);
    }
}
