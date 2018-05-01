import javax.swing.*;
import java.awt.*;
public abstract class Page extends JFrame{
    protected Container pane = getContentPane();
    protected GridBagConstraints constraints = new GridBagConstraints();

    protected void close() {
        setVisible(false);
        dispose();
    }

    protected void display() {
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    protected JPanel headerPanel = new JPanel(new GridBagLayout());
    protected void header(User user){
        //Header bar
        JLabel userLabel = new JLabel("Welcome " + user.getEmail());
        JButton signoutButton = new JButton("Sign Out");

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0, 10, 0, 10);
        headerPanel.add(userLabel, constraints);

        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.EAST;
        headerPanel.add(signoutButton, constraints);

        signoutButton.addActionListener(e -> {
            new LoginPage();
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
        pane.add(headerPanel, constraints);
    }

    private JButton homeButton = new JButton("Home");
    protected void home(){
        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(0, 10, 0, 10);
        headerPanel.add(homeButton, constraints);
    }

    protected void home(Customer user){
        home();
        homeButton.addActionListener(e -> {
            new MainPage(user);
            close();
        });
    }

    protected void home(Admin user){
        home();
        homeButton.addActionListener(e -> {
            new MainPage(user);
            close();
        });
    }

    protected Page(){
        //Pastels
        /*Color orange = new Color(255,179,71);
        Color red = new Color(255,87,71);*/
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        setTitle("Breaking Bread");
    }

}
