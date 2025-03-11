import java.awt.*;
import javax.swing.*;

public class client extends JFrame {

    public client() {
        setTitle("SocketSpeak");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        JPanel ipField = field("Server IP");
        JPanel passField = field("Password");

        add(ipField);
        add(passField);

        setVisible(true);
    }

    private static JPanel field(String fieldName) {
        JPanel panel = new JPanel();

        JLabel label = new JLabel(fieldName);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField text = new JTextField(10);
        text.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(label);
        panel.add(text);
        return panel;
    }

    public static void main(String[] args) {
        new client();
    }
}