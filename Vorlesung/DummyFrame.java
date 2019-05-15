import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DummyFrame extends JFrame {

    class ExitActionListener implements ActionListener {

        public void actionPerformed(ActionEvent arg) {

        }
    }

    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;

    public DummyFrame() {
        setTitle("Dummy");
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        menuBar = new JMenuBar();

        menuBar.add(new JMenuItem("Öffnen"));
        menuBar.add(new JMenuItem("Speichern"));

        menu.addSeparator();

        menu.add(menuItem = new JMenuItem("Beenden"));
        menuItem.addActionListener(new ExitActionListener());

        menu.add(menu = new JMenu("Bearbeiten"));

        menuBar.add(menuItem);

        this.setJMenuBar(menuBar);

        setVisible(true);
    }

    public static void main(String[] args) {
        new DummyFrame();
    }
}