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

    protected Page(){
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        setTitle("Breaking Bread");
    }

}
