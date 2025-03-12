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

        JPanel userInputFields = new JPanel();
        userInputFields.setPreferredSize(new Dimension(getWidth(), topHeight));
        userInputFields.setLayout(new BoxLayout(userInputFields, BoxLayout.Y_AXIS));

        JPanel userActionPanel = new JPanel();
        userActionPanel.setPreferredSize(new Dimension(getWidth(), (int) (getHeight() * (1.0 / 3.0))));

        addInputField(userInputFields, "IP:");
        addInputField(userInputFields, "Password:");

        add(userInputFields, BorderLayout.CENTER);
        add(userActionPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private static void addInputField(JPanel panel, String fieldName) {

        JLabel label = new JLabel(fieldName);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField text = new JTextField(10);
        text.setAlignmentX(Component.CENTER_ALIGNMENT);
        text.setMaximumSize(new Dimension(250, 30));

        panel.add(label);
        panel.add(text);
        panel.add(Box.createVerticalStrut(10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    public static void main(String[] args) {
        new client();
    }
}