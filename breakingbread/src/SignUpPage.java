import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SignUpPage extends JFrame{
    public SignUpPage() {
        JLabel nameLabel = new JLabel("Enter username: ");
        JLabel passwordLabel = new JLabel("Enter password: ");
        JLabel confirmLabel = new JLabel("Confirm password: ");
        JTextField nameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JPasswordField confirmField = new JPasswordField(20);
        JButton signUpButton = new JButton("Sign Up");
        JLabel errorLabel = new JLabel();
        JPanel panel = new JPanel(new GridBagLayout());

        signUpButton.addActionListener(e -> {
            String error;
            if(!Arrays.equals(passwordField.getPassword(), confirmField.getPassword())){
                errorLabel.setText("Passwords don't match");
                errorLabel.setVisible(true);
                pack();
            }
            else if (!(error = Application.signup(nameField.getText(),new String(passwordField.getPassword()))).isEmpty()){
                errorLabel.setText(error);
                errorLabel.setVisible(true);
                pack();
            }
            else{
                setVisible(false);
                dispose();
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

        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(confirmLabel, constraints);

        constraints.gridx = 1;
        panel.add(confirmField, constraints);


        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);

        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        panel.add(errorLabel, constraints);

        constraints.gridy = 4;
        panel.add(signUpButton, constraints);


        // add the panel to this frame
        add(panel);

        setTitle("Sign Up Page");
        pack();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
