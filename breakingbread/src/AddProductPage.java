import javax.swing.*;
import java.awt.*;

public class AddProductPage extends Page {
    private boolean authenicate(String name, String quantity, String price, String description, String path){
        try {
            Integer.parseInt(quantity);
            Float.parseFloat(price);
            new ImageIcon(getClass().getResource(path));
        }
        catch (Exception ex) {
            return false;
        }

        if(name.isEmpty() || description.isEmpty()){
            return false;
        }

        return true;
    }

    public AddProductPage(Admin user) {
        super();
        header(user);
        JLabel nameLabel = new JLabel("Enter product name: ");
        JLabel quantityLabel = new JLabel("Enter product quantity: ");
        JLabel priceLabel = new JLabel("Enter product price:");
        JLabel pathLabel = new JLabel("Enter image file path:");
        JLabel descriptionLabel = new JLabel("Enter description: ");
        JLabel errorLabel = new JLabel("Product could not be created:");
        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);

        JTextField nameField = new JTextField(20);
        JTextField quantityField = new JTextField(20);
        JTextField priceField = new JTextField(20);
        JTextField pathField = new JTextField(20);
        JTextArea descriptionField = new JTextArea(5,20);

        JButton addButton = new JButton("Add Product");
        addButton.addActionListener(e -> {
            if(authenicate(nameField.getText(),quantityField.getText(),priceField.getText(),descriptionField.getText(),pathField.getText())){
                Product newProduct = new Product(0,Integer.parseInt(quantityField.getText()),
                        nameField.getText(),descriptionField.getText(),pathField.getText(),
                        Float.parseFloat(priceField.getText()));
                Inventory.getInstance().addProduct(newProduct);
                new MainPage(user);
                close();
            }
            else {
                errorLabel.setVisible(true);
                pack();
            }
        });

        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 0;
        constraints.gridy = 1;
        pane.add(nameLabel, constraints);
        constraints.gridx = 1;
        pane.add(nameField, constraints);

        constraints.gridx = 0;
        constraints.gridy++;
        pane.add(priceLabel, constraints);
        constraints.gridx = 1;
        pane.add(priceField, constraints);

        constraints.gridx = 0;
        constraints.gridy++;
        pane.add(quantityLabel, constraints);
        constraints.gridx = 1;
        pane.add(quantityField, constraints);

        constraints.gridx = 0;
        constraints.gridy++;
        pane.add(pathLabel, constraints);
        constraints.gridx = 1;
        pane.add(pathField, constraints);

        constraints.gridx = 0;
        constraints.gridy++;
        constraints.gridwidth = 2;
        pane.add(descriptionLabel, constraints);
        constraints.gridy++;
        pane.add(descriptionField, constraints);

        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 0;
        constraints.gridy++;
        constraints.gridwidth = 2;
        pane.add(errorLabel, constraints);

        constraints.gridy++;
        pane.add(addButton, constraints);
        display();
    }
}
