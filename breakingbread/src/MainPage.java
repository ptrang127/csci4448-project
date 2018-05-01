import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainPage extends Page {
    public MainPage(Admin user) {

    }
    public MainPage(Customer user) {
        super();

        //Pastels
        /*Color orange = new Color(255,179,71);
        Color red = new Color(255,87,71);
        getContentPane().setBackground(orange);*/

        //search Bar
        JButton searchButton = new JButton("Search");
        JTextField searchField = new JTextField(20);
        JPanel searchPanel = new JPanel(new GridBagLayout());

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(0,10,0,10);
        constraints.anchor = GridBagConstraints.WEST;
        searchPanel.add(searchField,constraints);

        constraints.gridx = 1;
        constraints.weightx = 0;
        constraints.anchor = GridBagConstraints.EAST;
        searchPanel.add(searchButton,constraints);


        //search Functionality
        ActionListener searchFunction = e -> {
            //Application.results(searchField.getText());
            close();
        };

        searchButton.addActionListener(searchFunction);
        searchField.addActionListener(searchFunction);

        //Header bar
        JPanel headerPanel = new JPanel(new GridBagLayout());

        JLabel userLabel = new JLabel("Welcome " + user.getEmail());
        JButton signoutButton = new JButton("Sign Out");

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0, 10, 0, 10);

        headerPanel.add(userLabel, constraints);
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.WEST;
        headerPanel.add(signoutButton, constraints);

        signoutButton.addActionListener(e -> {
            new LoginPage();
            close();
        });

        JButton cart = new JButton(String.format("Cart"));
        constraints.gridx = 2;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.weightx = 1.0;
        headerPanel.add(cart, constraints);
        cart.addActionListener(e -> {
            Application.cart();
            close();
        });



        // add components to the content pane
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 0, 10, 0);
        //headerPanel.setBackground(red);
        add(headerPanel, constraints);


        constraints.gridy++;
        constraints.weighty = 1.0;
        //searchPanel.setBackground(orange);
        add(searchPanel, constraints);

        display();
    }
}
