package com.example.calculator;

import com.example.calculator.controller.CalculatorController;
import com.example.calculator.model.CalculatorModel;
import com.example.calculator.view.CalculatorView;
import javax.swing.SwingUtilities;

public class CalculatorApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorModel model = new CalculatorModel();
            CalculatorView view = new CalculatorView();
            new CalculatorController(model, view);
            view.setVisible(true);
        });
    }
}