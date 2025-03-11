import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class client extends JFrame {
    
    public client() {
        setTitle("SocketSpeak");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        setVisible(true);
    }


    public static void main(String[] args) {
        new client();
    }
}
