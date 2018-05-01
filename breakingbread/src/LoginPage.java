import javax.swing.*;
import java.awt.*;

public class LoginPage extends Page{
    public LoginPage() {
        super();

        JLabel nameLabel = new JLabel("Enter username: ");
        JLabel passwordLabel = new JLabel("Enter password: ");
        JLabel errorLabel = new JLabel("Username or password is incorrect");
        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);

        JTextField nameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            if(!Application.login(nameField.getText(), new String(passwordField.getPassword()))){
                errorLabel.setVisible(true);
                pack();
            }
            else{
                close();
            }
        });

        JButton signUpButton = new JButton("Sign up");
        signUpButton.addActionListener(e ->{
            new SignUpPage();
            close();
        });

        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        pane.add(nameLabel, constraints);

        constraints.gridx = 1;
        pane.add(nameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        pane.add(passwordLabel, constraints);

        constraints.gridx = 1;
        pane.add(passwordField, constraints);

        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        pane.add(errorLabel, constraints);

        constraints.gridy = 3;
        pane.add(loginButton, constraints);

        constraints.gridy = 4;
        pane.add(signUpButton, constraints);

        display();
    }
}