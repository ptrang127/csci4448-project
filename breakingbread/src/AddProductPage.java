import javax.swing.*;
import java.awt.*;

public class AddProductPage extends Page {
    public AddProductPage(Admin user) {
        super();
        header(user);
        JLabel nameLabel = new JLabel("Enter username: ");
        JLabel passwordLabel = new JLabel("Enter password: ");
        JLabel errorLabel = new JLabel("Product could not be created");
        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);

        JButton addButton = new JButton("Login");
        addButton.addActionListener(e -> {

        });

        JTextField nameField = new JTextField(20);


        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        pane.add(errorLabel, constraints);

        constraints.gridy = 3;
        pane.add(addButton, constraints);
        display();
    }
}
