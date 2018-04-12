import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {
    private final JTextField nameInput, passwordInput;
    public static void main(String[] args) {
        Application frame = new Application();
    }
    public Application() {
        JLabel nameLabel = new JLabel("Username", SwingConstants.RIGHT);
        nameInput = new JTextField(15);

        JLabel passwordLabel = new JLabel("Password", SwingConstants.RIGHT);
        passwordInput = new JPasswordField(15);

        JButton login = new JButton("Login");

        JPanel panel = new JPanel();
        SpringLayout panelLayout = new SpringLayout();
        panel.setLayout(panelLayout);

        panel.add(nameLabel);
        panel.add(nameInput);
        panel.add(passwordLabel);
        panel.add(passwordInput);

        int padding = 5;
        panelLayout.putConstraint(SpringLayout.NORTH, nameLabel, padding, SpringLayout.NORTH, panel);
        panelLayout.putConstraint(SpringLayout.WEST, nameLabel, padding, SpringLayout.WEST, panel);

        panelLayout.putConstraint(SpringLayout.NORTH, nameInput, 0, SpringLayout.NORTH, nameLabel);
        panelLayout.putConstraint(SpringLayout.WEST, nameInput, padding, SpringLayout.EAST, nameLabel);
        panelLayout.putConstraint(SpringLayout.EAST, nameInput, 0, SpringLayout.EAST, passwordInput);

        panelLayout.putConstraint(SpringLayout.NORTH, passwordLabel, padding, SpringLayout.SOUTH, nameLabel);
        panelLayout.putConstraint(SpringLayout.EAST, passwordLabel, 0, SpringLayout.EAST, nameLabel);

        panelLayout.putConstraint(SpringLayout.NORTH, passwordInput, padding, SpringLayout.SOUTH, nameInput);
        panelLayout.putConstraint(SpringLayout.WEST, passwordInput, 0, SpringLayout.WEST, nameInput);

        panelLayout.putConstraint(SpringLayout.NORTH, login, padding, SpringLayout.SOUTH, passwordLabel);

        panelLayout.putConstraint(SpringLayout.SOUTH, panel, padding, SpringLayout.SOUTH, login);
        panelLayout.putConstraint(SpringLayout.EAST, panel, padding, SpringLayout.EAST, passwordInput);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        add(panel, BorderLayout.CENTER);
        add(login, BorderLayout.CENTER);

        setTitle("Application Form");

        pack();
        setDefaultCloseOperation(javax.swing.
                WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}

