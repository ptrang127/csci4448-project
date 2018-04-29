import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame{
    private JLabel labelUsername = new JLabel("Search: ");
    private JTextField textUsername = new JTextField(20);
    private JPanel panel = new JPanel();

    public  MainPage(User user) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        textUsername.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.Search(textUsername.getText());
                setVisible(false);
                dispose();
            }
        });

        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(labelUsername, constraints);

        constraints.gridx = 1;
        panel.add(textUsername, constraints);

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
