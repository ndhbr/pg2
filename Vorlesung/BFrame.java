import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class BFrame extends JFrame {

    class OkActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {

        }
    }

    public BFrame(String initValue) {
        setTitle("Betone!");
        setSize(800, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);



        setVisible(true);
    }

    public static void main(String [] args) {
        BFrame b = new BFrame("Abc");

    }
}