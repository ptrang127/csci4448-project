import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainPage extends Page {
    private JButton searchButton = new JButton("Search");
    private JTextField searchField = new JTextField(20);
    private JPanel searchPanel = new JPanel(new GridBagLayout());

    private void search() {
        //search Bar
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(0,10,0,10);
        constraints.anchor = GridBagConstraints.WEST;
        searchPanel.add(searchField,constraints);

        constraints.gridx = 1;
        constraints.weightx = 0;
        constraints.anchor = GridBagConstraints.EAST;
        searchPanel.add(searchButton,constraints);

        // add components to the content pane
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 0, 10, 0);
        //searchPanel.setBackground(orange);
        pane.add(searchPanel, constraints);
    }

    public MainPage(Admin user) {
        super();
        header(user);
        search();
        //search Functionality
        ActionListener searchFunction = e -> {
            new ResultsPage(searchField.getText(), user);
            close();
        };

        searchButton.addActionListener(searchFunction);
        searchField.addActionListener(searchFunction);
        display();
    }

    public MainPage(Customer user) {
        super();
        header(user);
        search();
        //search Functionality
        ActionListener searchFunction = e -> {
            new ResultsPage(searchField.getText(), user);
            close();
        };

        searchButton.addActionListener(searchFunction);
        searchField.addActionListener(searchFunction);

        JButton cart = new JButton(String.format("Cart"));
        constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.weightx = 1.0;
        headerPanel.add(cart, constraints);
        cart.addActionListener(e -> {
            new CartPage(user);
            close();
        });


        display();
    }
}
