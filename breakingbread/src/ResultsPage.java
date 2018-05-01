import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class ResultsPage extends JFrame {
//    public ResultsPage(String query, User user) {
//        //Overall layout
//        setLayout(new GridBagLayout());
//        GridBagConstraints constraints = new GridBagConstraints();
//        //Pastels
//        /*Color orange = new Color(255,179,71);
//        Color red = new Color(255,87,71);
//        getContentPane().setBackground(orange);*/
//
//        //search Bar
//        JButton searchButton = new JButton("Search");
//        JTextField searchField = new JTextField(query, 20);
//        JPanel searchPanel = new JPanel(new GridBagLayout());
//
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//        constraints.weightx = 1.0;
//        constraints.fill = GridBagConstraints.HORIZONTAL;
//        constraints.insets = new Insets(0,10,0,10);
//        constraints.anchor = GridBagConstraints.WEST;
//        searchPanel.add(searchField,constraints);
//
//        constraints.gridx = 1;
//        constraints.weightx = 0;
//        constraints.anchor = GridBagConstraints.EAST;
//        searchPanel.add(searchButton,constraints);
//
//
//        //results
//        DefaultListModel<Product> listModel = new DefaultListModel<>();
//        JList<Product> results = new JList(listModel);
//        JLabel message = new JLabel();
//        JScrollPane scroll = new JScrollPane(results);
//        JPanel resultsPanel = new JPanel(new GridBagLayout());
//
//        constraints = new GridBagConstraints();
//        constraints.insets = new Insets(0,10,0,10);
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//        constraints.anchor = GridBagConstraints.NORTHWEST;
//        resultsPanel.add(message, constraints);
//
//        constraints.gridx = 0;
//        constraints.gridy = 1;
//        constraints.weightx = 1;
//        constraints.weighty = 1;
//        constraints.fill = GridBagConstraints.VERTICAL;
//        constraints.anchor = GridBagConstraints.NORTHWEST;
//        resultsPanel.add(scroll, constraints);
//
//        //search functionality
//        ActionListener searchFunction = e -> {
//            listModel.clear();
//            List<Product> products = Application.search(searchField.getText());
//            if(products.isEmpty()){
//                message.setText("No results");
//                pack();
//                return;
//            }
//            java.util.Iterator<Product> itr = products.iterator();
//
//            while (itr.hasNext()){
//                message.setText("Results:");
//                scroll.setVisible(true);
//                listModel.addElement(itr.next());
//            }
//            pack();
//        };
//
//        results.addListSelectionListener(e -> {
//            if (!e.getValueIsAdjusting()) {
//                Product product = results.getSelectedValue();
//                Application.product(product);
//                setVisible(false);
//                dispose();
//            }
//        });
//
//        searchButton.addActionListener(searchFunction);
//        searchField.addActionListener(searchFunction);
//        searchButton.doClick();
//
//        //Header bar
//        JPanel headerPanel = new JPanel(new GridBagLayout());
//
//        JLabel userLabel = new JLabel("Welcome " + user.getEmail());
//        JButton signoutButton = new JButton("Sign Out");
//
//        constraints = new GridBagConstraints();
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//        constraints.weightx = 1.0;
//        constraints.anchor = GridBagConstraints.WEST;
//        constraints.insets = new Insets(0, 10, 0, 10);
//
//        headerPanel.add(userLabel, constraints);
//        constraints.gridx = 1;
//        constraints.anchor = GridBagConstraints.EAST;
//        headerPanel.add(signoutButton, constraints);
//
//        signoutButton.addActionListener(e -> {
//            Application.signout();
//            setVisible(false);
//            dispose();
//        });
//
//
//        // add components to the content pane
//        constraints = new GridBagConstraints();
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//        constraints.weightx = 1.0;
//        constraints.anchor = GridBagConstraints.NORTHWEST;
//        constraints.fill = GridBagConstraints.HORIZONTAL;
//        constraints.insets = new Insets(10, 0, 10, 0);
//        //headerPanel.setBackground(red);
//        add(headerPanel, constraints);
//
//
//        constraints.gridy++;
//        //searchPanel.setBackground(orange);
//        add(searchPanel, constraints);
//
//        constraints.gridy++;
//        constraints.weighty = 1.0;
//        add(resultsPanel, constraints);
//
//        setSize(5000,5000);
//        pack();
//        setTitle("Search Results");
//        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setResizable(true);
//        setVisible(true);
//    }
}
