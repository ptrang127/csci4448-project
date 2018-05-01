import javax.swing.*;
import java.awt.*;

public class ProductPage extends Page{
    public ProductPage(Product product) {
        super();

        JLabel name = new JLabel(product.getName());
        JLabel description = new JLabel(product.getDescription());
        JLabel thumbnail = new JLabel(new ImageIcon(getClass().getResource("scone.jpg")));
        JLabel label = new JLabel("Quantity: ");
        JTextField field = new JTextField(String.format("%d", product.getQuantity()), 5);
        JButton backButton = new JButton("Back");
        JButton addButton = new JButton("Add to Cart");
        addButton.addActionListener(e -> {
            //Application.addcart(product);
            close();
        });

        constraints.insets = new Insets(10,10,10,10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        pane.add(name, constraints);

        constraints.gridy++;
        pane.add(description, constraints);

        constraints.gridy++;
        constraints.weighty = 1;
        constraints.gridwidth = 3;
        pane.add(thumbnail, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.weightx = 0;
        constraints.anchor = GridBagConstraints.NORTHEAST;
        pane.add(backButton, constraints);
        constraints.gridy = 1;
        pane.add(field, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        pane.add(addButton, constraints);
        constraints.gridy = 1;
        pane.add(label, constraints);

        display();
    }
}
