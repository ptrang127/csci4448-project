import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainPage extends JFrame{
    public MainPage(User user) {
        JButton searchButton = new JButton("Search");
        JTextField searchField = new JTextField(20);
        JPanel panel = new JPanel(new GridBagLayout());
        JLabel message = new JLabel();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> results = new JList(listModel);
        JScrollPane scroll = new JScrollPane(results);

        ActionListener searchFunction = e -> {
            java.util.List<Product> products = Application.Search(searchField.getText());
            listModel.clear();
            if(products.isEmpty()){
                message.setText("No results");
                pack();
                return;
            }
            java.util.Iterator<Product> itr = products.iterator();

            while (itr.hasNext()){
                message.setText("Results:");
                scroll.setVisible(true);
                listModel.addElement(itr.next().getName());
            }
            pack();
        };

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        searchButton.addActionListener(searchFunction);
        searchField.addActionListener(searchFunction);

        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(searchField, constraints);

        constraints.gridx = 1;
        panel.add(searchButton, constraints);

        //constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(message, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        results.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        panel.add(scroll, constraints);
        scroll.setVisible(false);

        add(panel);

        pack();
        setTitle("Breaking Bread");
        setDefaultCloseOperation(javax.swing.
                WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }



}
