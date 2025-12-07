package com.example.calculator.controller;

import com.example.calculator.model.CalculatorModel;
import com.example.calculator.view.CalculatorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController implements ActionListener {
    private final CalculatorModel model;
    private final CalculatorView view;
    private String pendingOperator = null;
    private Double leftOperand = null;
    private boolean resetDisplay = false;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        view.addCalcListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        try {
            if (cmd.matches("[0-9]") || cmd.equals(".")) {
                handleDigit(cmd);
            } else if (cmd.equals("C")) {
                clearAll();
            } else if (cmd.equals("=")) {
                handleEquals();
            } else { 
                handleOperator(cmd);
            }
        } catch (Exception ex) {
            view.setDisplay("Error");
            clearAll();
        }
    }

    private void handleDigit(String d) {
        String cur = view.getDisplay();
        if (resetDisplay || "0".equals(cur) || "Error".equals(cur)) {
            cur = "";
            resetDisplay = false;
        }
        if (d.equals(".") && cur.contains(".")) return;
        view.setDisplay(cur + d);
    }

    private void handleOperator(String op) {
        String curText = view.getDisplay();
        if (!curText.isEmpty() && !curText.equals("Error")) {
            double curVal = Double.parseDouble(curText);
            if (leftOperand == null) {
                leftOperand = curVal;
            } else if (pendingOperator != null && !resetDisplay) {
                leftOperand = model.calculate(leftOperand, pendingOperator, curVal);
                view.setDisplay(trimDouble(leftOperand));
            }
            pendingOperator = op;
            resetDisplay = true;
        }
    }

    private void handleEquals() {
        if (pendingOperator == null || leftOperand == null) return;
        String curText = view.getDisplay();
        if(curText.isEmpty() || curText.equals("Error")) return;
        
        double right = Double.parseDouble(curText);
        double result = model.calculate(leftOperand, pendingOperator, right);
        view.setDisplay(trimDouble(result));
        leftOperand = result;
        pendingOperator = null;
        resetDisplay = true;
    }

    private void clearAll() {
        pendingOperator = null;
        leftOperand = null;
        resetDisplay = false;
        view.setDisplay("0");
    }

    private String trimDouble(double v) {
        if (v == (long) v) return String.format("%d", (long) v);
        return String.format("%s", v);
    }
}