import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class ResultsPage extends Page {
    //results
    private DefaultListModel listModel = new DefaultListModel<>();
    private JList results = new JList(listModel);
    private JLabel message = new JLabel();
    private JScrollPane scroll = new JScrollPane(results);
    private JPanel resultsPanel = new JPanel(new GridBagLayout());
    private JButton searchButton = new JButton("Search");
    private JTextField searchField = new JTextField( 20);
    private void search(String query){
        //search Bar
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
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 1.0;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 0, 10, 0);
        //searchPanel.setBackground(orange);
        pane.add(searchPanel, constraints);
    }

    private void results(){
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
            List<Product> products = Inventory.getInstance().searchProduct(searchField.getText());
            if(products.isEmpty()){
                message.setText("No results");
            }
            else{
                message.setText("Results:");
                scroll.setVisible(true);
                products.forEach(product -> {
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
        constraints.gridy = 2;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 0, 10, 0);
        pane.add(resultsPanel, constraints);
    }

    public ResultsPage(Admin user, String type){
        super();
        header(user);
        home(user);
        ActionListener searchFunction;
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

        listModel.clear();

        switch (type) {
            case "Product":
                List<Product> products = Inventory.getInstance().searchProduct("");
                if(products.isEmpty()){
                    message.setText("No products");
                }
                else{
                    message.setText("Products:");
                    scroll.setVisible(true);
                    products.forEach(product -> {
                        listModel.addElement(product);
                    });
                }
                pack();

                results.addListSelectionListener(e -> {
                    if (!e.getValueIsAdjusting()) {
                        Product product = (Product) results.getSelectedValue();
                        Inventory.deleteProduct(product);
                        new ResultsPage(user,type);
                        close();
                    }
                });
                break;
            case "Account":
                List<Customer> customers = Application.getCustomers();
                if(customers.isEmpty()){
                    message.setText("No customer accounts");
                }
                else{
                    message.setText("Customer accounts:");
                    scroll.setVisible(true);
                    customers.forEach(product -> {
                        listModel.addElement(product);
                    });
                }
                pack();

                results.addListSelectionListener(e -> {
                    if (!e.getValueIsAdjusting()) {
                        Customer customer = (Customer) results.getSelectedValue();
                        Application.removeAccount(customer.getID());
                        new ResultsPage(user, type);
                        close();
                    }
                });
                break;
        }

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 0, 10, 0);
        pane.add(resultsPanel, constraints);

        display();
    }

    protected ResultsPage(String query, Customer user) {
        super();
        header(user);
        home(user);
        results.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Product product = (Product) results.getSelectedValue();
                new ProductPage(user, product);
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
        results();
        display();
    }
}
