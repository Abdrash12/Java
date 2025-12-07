package MVC_Calculator;

public package com.example.calculator.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    private final JTextField display = new JTextField("0", 20);
    private final String[] BUTTONS = {
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", ".", "=", "+",
        "C"
    };
    private final java.util.List<JButton> buttons = new java.util.ArrayList<>();

    public CalculatorView() {
        super("MVC Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(6, 6));
        
        // Styling the display
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setFont(new Font("SansSerif", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        // Creating button grid
        JPanel center = new JPanel(new GridLayout(5, 4, 5, 5));
        for (String label : BUTTONS) {
            JButton btn = new JButton(label);
            btn.setActionCommand(label);
            btn.setFont(new Font("SansSerif", Font.PLAIN, 20));
            buttons.add(btn);
            center.add(btn);
        }
        add(center, BorderLayout.CENTER);
        
        pack();
        setLocationRelativeTo(null); // Center on screen
    }

    public void addCalcListener(ActionListener listener) {
        for (JButton b : buttons) b.addActionListener(listener);
    }

    public void setDisplay(String text) {
        display.setText(text);
    }

    public String getDisplay() {
        return display.getText();
    }
} {
    
}
