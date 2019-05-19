import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class CalculatorFrame extends JFrame {

    Calculator calculator;

    public CalculatorFrame() {
        calculator = new Calculator();
        initGui();
    }

    private void initGui() {
        setTitle("Taschenrechner");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 3));

        JMenuBar menuBar = initMenuBar();
        setJMenuBar(menuBar);

        add(new JLabel("Ergebnis:", JLabel.LEFT));
        add(new JLabel("Funktion:", JLabel.LEFT));
        add(new JLabel("Argument:", JLabel.LEFT));

        String[] functions = {"+", "*"};

        JTextField resultField = new JTextField();
        JTextField argumentField = new JTextField();
        JComboBox functionField = new JComboBox<String>(functions);

        resultField.setEditable(false);
        resultField.setText(String.valueOf(calculator.getResult()));

        add(resultField);
        add(functionField);
        add(argumentField);

        JButton calcBtn = new JButton("Berechnen");
        JButton undoBtn = new JButton("Rückgängig");
        JButton clearBtn = new JButton("Zurücksetzen");

        add(calcBtn);
        add(undoBtn);
        add(clearBtn);

        pack();
        setVisible(true);
    }

    private JMenuBar initMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuBarFile = new JMenu("Datei");
        JMenu menuBarEdit = new JMenu("Bearbeiten");
        JMenuItem menuUndo = new JMenuItem("Rückgängig");
        JMenuItem menuClear = new JMenuItem("Zurücksetzen");

        menuBar.add(menuBarFile);
        menuBar.add(menuBarEdit);

        menuBarEdit.add(menuUndo);
        menuBarEdit.add(menuClear);

        menuUndo.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                calculator.undo();
            }
        });

        menuClear.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                calculator.clear();
            }
        });

        return menuBar;
    }

    public static void main(String args[]) {
        CalculatorFrame c = new CalculatorFrame();
    }
}