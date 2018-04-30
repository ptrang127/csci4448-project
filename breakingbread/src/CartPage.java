import java.awt.*;
import javax.swing.*;

public class CartPage extends JFrame{
    public CartPage(User user) {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        pack();
        setTitle("Breaking Bread");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
