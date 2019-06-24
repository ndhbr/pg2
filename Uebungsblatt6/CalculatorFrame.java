import java.awt.BorderLayout;
import java.awt.Container;
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
import javax.swing.border.Border;

public class CalculatorFrame extends JFrame {

    Calculator calculator;
    private JTextField resultField;
    private JTextField argumentField;
    private JComboBox functionField;

    public CalculatorFrame() {
        calculator = new Calculator();
        initGui();
    }

    private void initGui() {
        setTitle("Taschenrechner");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        BorderLayout borderLayout = new BorderLayout();

        setLayout(borderLayout);

        JMenuBar menuBar = initMenuBar();
        setJMenuBar(menuBar);

        String[] functions = {"+", "*"};

        resultField = new JTextField();
        argumentField = new JTextField();
        functionField = new JComboBox<String>(functions);

        resultField.setEditable(false);
        updateResult();

        add(new JLabel("Ergebnis:", JLabel.LEFT), BorderLayout.LINE_START);
        add(resultField, BorderLayout.LINE_END);
        add(new JLabel("Funktion:", JLabel.LEFT), BorderLayout.LINE_START);
        add(functionField, BorderLayout.LINE_END);
        add(new JLabel("Argument:", JLabel.LEFT), BorderLayout.LINE_START);
        add(argumentField, BorderLayout.LINE_END);

        JButton calcBtn = new JButton("Berechnen");
        JButton undoBtn = new JButton("Rückgängig");
        JButton clearBtn = new JButton("Zurücksetzen");

        calcBtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                double argument;

                try {
                    argument = Double.valueOf(argumentField.getText());

                    if(functionField.getSelectedItem().toString().equals("+")) {
                        calculator.apply(new Addition(), argument);
                    } else {
                        calculator.apply(new Multiplication(), argument);
                    }

                    updateResult();
                } catch(NumberFormatException exception) {
                    resultField.setText("Ungültige Eingabe!");
                }
            }
        });

        undoBtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                doUndo();
            }
        });

        clearBtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                doClear();
            }
        });

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
                doUndo();
            }
        });

        menuClear.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                doClear();
            }
        });

        return menuBar;
    }

    private void doUndo() {
        calculator.undo();
        updateResult();
    }

    private void doClear() {
        calculator.clear();
        updateResult();
    }

    private void updateResult() {
        String newResult = String.valueOf(calculator.getResult());
        resultField.setText(newResult);
    }

    public static void main(String args[]) {
        CalculatorFrame c = new CalculatorFrame();
    }
}