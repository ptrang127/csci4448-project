import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SignUpPage extends Page{
    public SignUpPage() {
        super();

        JLabel emailLabel = new JLabel("Enter email: ");
        JLabel passwordLabel = new JLabel("Enter password: ");
        JLabel confirmLabel = new JLabel("Confirm password: ");
        JLabel addressLabel = new JLabel("Enter address: ");
        JLabel errorLabel = new JLabel();

        JTextField emailField = new JTextField(20);
        JTextField addressField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JPasswordField confirmField = new JPasswordField(20);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(e -> {
            String error;
            if(!Arrays.equals(passwordField.getPassword(), confirmField.getPassword())){
                errorLabel.setText("Passwords don't match");
                errorLabel.setVisible(true);
                pack();
            }
            else if (!(error = Application.signup(emailField.getText(),new String(passwordField.getPassword()),addressField.getText())).isEmpty()){
                errorLabel.setText(error);
                errorLabel.setVisible(true);
                pack();
            }
            else{
                close();
            }
        });

        JButton adminButton = new JButton("Admin Sign Up");
        adminButton.addActionListener(e ->{
            new AdminSignUpPage();
            close();
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            new LoginPage();
            close();
        });

        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        pane.add(backButton, constraints);


        constraints.gridy++;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.WEST;
        pane.add(emailLabel, constraints);

        constraints.gridx = 1;
        pane.add(emailField, constraints);

        constraints.gridx = 0;
        constraints.gridy++;
        pane.add(addressLabel, constraints);

        constraints.gridx = 1;
        pane.add(addressField, constraints);

        constraints.gridx = 0;
        constraints.gridy++;
        pane.add(passwordLabel, constraints);

        constraints.gridx = 1;
        pane.add(passwordField, constraints);

        constraints.gridx = 0;
        constraints.gridy++;
        pane.add(confirmLabel, constraints);

        constraints.gridx = 1;
        pane.add(confirmField, constraints);


        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);

        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 0;
        constraints.gridy++;
        constraints.gridwidth = 2;
        pane.add(errorLabel, constraints);

        constraints.gridy++;
        constraints.gridwidth = 1;
        pane.add(signUpButton, constraints);

        constraints.gridx = 1;
        pane.add(adminButton, constraints);

        display();
    }
}
