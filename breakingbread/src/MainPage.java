import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame{
    private JLabel searchLabel = new JLabel("Search: ");
    private JTextField searchField = new JTextField(20);
    private  JLabel searchResults= new JLabel();
    private JPanel panel = new JPanel(new GridBagLayout());


    public MainPage(User user) {
        searchField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                java.util.List<Product> products = Application.Search(searchField.getText());
                if(products.isEmpty()){
                    searchResults.setText("No results");
                    return;
                }
                java.util.Iterator<Product> itr = products.iterator();
                int i = 1;
                String results = "<html>";
                while (i++ < 20 && itr.hasNext()){
                    i++;
                    results+=itr.next().getName() + "<br>";
                }
                results+="</html>";
                searchResults.setText(results);
                pack();
            }
        });
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(searchLabel, constraints);

        constraints.gridx = 1;
        panel.add(searchField, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(searchResults, constraints);

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
