import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class ResultsPage extends Page {
    //results
    private DefaultListModel<Product> listModel = new DefaultListModel<>();
    private JList<Product> results = new JList(listModel);
    private JLabel message = new JLabel();
    private JScrollPane scroll = new JScrollPane(results);
    private JPanel resultsPanel = new JPanel(new GridBagLayout());
    private void search(String query){
        //search Bar
        JButton searchButton = new JButton("Search");
        JTextField searchField = new JTextField(query, 20);
        JPanel searchPanel = new JPanel(new GridBagLayout());

        constraints = new GridBagConstraints();
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

        constraints = new GridBagConstraints();
        constraints.insets = new Insets(0,10,0,10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        resultsPanel.add(message, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        resultsPanel.add(scroll, constraints);

        //search functionality
        ActionListener searchFunction = e -> {
            listModel.clear();
            List<Product> products = Application.searchProduct(searchField.getText());
            if(products.isEmpty()){
                message.setText("No results");
            }
            else{
                message.setText("Results:");
                products.forEach(product -> {
                    scroll.setVisible(true);
                    listModel.addElement(product);
                });
            }
            pack();
        };

        searchButton.addActionListener(searchFunction);
        searchField.addActionListener(searchFunction);
        searchButton.doClick();

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 1.0;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 0, 10, 0);
        //searchPanel.setBackground(orange);
        pane.add(searchPanel, constraints);

        constraints.gridy++;
        constraints.weighty = 1.0;
        pane.add(resultsPanel, constraints);

        display();
    }
    public ResultsPage(String query, Admin user){
        super();
        header(user);
        home(user);
        results.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Product product = results.getSelectedValue();
                //TODO make admin product pages
                close();
            }
        });
        search(query);
    }

    protected ResultsPage(String query, Customer user) {
        super();
        header(user);
        home(user);
        results.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Product product = results.getSelectedValue();
                new ProductPage(product);
                close();
            }
        });
        JButton cart = new JButton("Cart");
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.weightx = 1.0;
        headerPanel.add(cart, constraints);
        cart.addActionListener(e -> {
            new CartPage(user);
            close();
        });
        search(query);
    }
}
