import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame{
    private JLabel nameLabel = new JLabel("Enter username: ");
    private JLabel passwordLabel = new JLabel("Enter password: ");
    private JTextField nameField = new JTextField(20);
    private JPasswordField passwordField = new JPasswordField(20);
    private JButton loginButton = new JButton("Login");
    private JLabel errorLabel = new JLabel("Username or password is incorrect");
    private JPanel panel = new JPanel(new GridBagLayout());


    public LoginPage() {
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!Application.Login(nameField.getText(), passwordField.getText())){
                    errorLabel.setVisible(true);
                    pack();
                }
                else{
                    setVisible(false);
                    dispose();
                }
            }
        });

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(nameLabel, constraints);

        constraints.gridx = 1;
        panel.add(nameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(passwordLabel, constraints);

        constraints.gridx = 1;
        panel.add(passwordField, constraints);


        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);

        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 4;
        panel.add(errorLabel, constraints);

        constraints.gridy = 3;
        constraints.gridwidth = 2;
        panel.add(loginButton, constraints);

        // add the panel to this frame
        add(panel);

        setTitle("LoginPage Form");
        pack();
        setDefaultCloseOperation(javax.swing.
                WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}