import java.awt.*;
import javax.swing.*;

public class client extends JFrame {

    public client() {
        setTitle("SocketSpeak");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        
        int topHeight = (int) (getHeight() * (2.0 / 3.0));

        JPanel inputFields = new JPanel();
        inputFields.setPreferredSize(new Dimension(getWidth(), topHeight));
        // JPanel passField = inputField("Password");

        add(inputFields, BorderLayout.NORTH);

        setVisible(true);
    }
    // private static JPanel inputField(String fieldName) {
    //     JPanel panel = new JPanel();

    //     JLabel label = new JLabel(fieldName);
    //     label.setAlignmentX(Component.CENTER_ALIGNMENT);

    //     JTextField text = new JTextField(10);
    //     text.setAlignmentX(Component.CENTER_ALIGNMENT);

    //     panel.add(label);
    //     panel.add(text);
    //     return panel;
    // }

    public static void main(String[] args) {
        new client();
    }
}