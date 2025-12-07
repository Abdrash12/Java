package com.example.calculator.model;

public class CalculatorModel {
    /**
     * Performs binary arithmetic operations.
     */
    public double calculate(double a, String operator, double b) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
            default: throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}