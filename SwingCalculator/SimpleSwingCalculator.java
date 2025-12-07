import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class SimpleSwingCalculator {

    private JFrame frame;
    private JTextField textField;
    
    // Variables to store state
    double firstNum;
    double secondNum;
    double result;
    String operation;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SimpleSwingCalculator window = new SimpleSwingCalculator();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SimpleSwingCalculator() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 290, 410);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Swing Calculator");
        frame.getContentPane().setLayout(null);
        
        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setFont(new Font("Tahoma", Font.BOLD, 18));
        textField.setBounds(10, 11, 254, 49);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        // --- Button Logic Helper ---
        ActionListener numListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String val = ((JButton)e.getSource()).getText();
                textField.setText(textField.getText() + val);
            }
        };

        ActionListener opListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!textField.getText().isEmpty()) {
                    firstNum = Double.parseDouble(textField.getText());
                    textField.setText("");
                    operation = ((JButton)e.getSource()).getText();
                }
            }
        };

        // --- Row 1 (Clear, +, ...) ---
        JButton btnClear = new JButton("C");
        btnClear.addActionListener(e -> textField.setText(""));
        btnClear.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnClear.setBounds(10, 71, 122, 60);
        frame.getContentPane().add(btnClear);
        
        JButton btnPlus = new JButton("+");
        btnPlus.addActionListener(opListener);
        btnPlus.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnPlus.setBounds(208, 71, 56, 60);
        frame.getContentPane().add(btnPlus);
        
        // --- Row 2 (7, 8, 9, -) ---
        JButton btn7 = new JButton("7"); btn7.addActionListener(numListener);
        btn7.setFont(new Font("Tahoma", Font.BOLD, 18));
        btn7.setBounds(10, 142, 56, 60);
        frame.getContentPane().add(btn7);
        
        JButton btn8 = new JButton("8"); btn8.addActionListener(numListener);
        btn8.setFont(new Font("Tahoma", Font.BOLD, 18));
        btn8.setBounds(76, 142, 56, 60);
        frame.getContentPane().add(btn8);
        
        JButton btn9 = new JButton("9"); btn9.addActionListener(numListener);
        btn9.setFont(new Font("Tahoma", Font.BOLD, 18));
        btn9.setBounds(142, 142, 56, 60);
        frame.getContentPane().add(btn9);
        
        JButton btnSub = new JButton("-");
        btnSub.addActionListener(opListener);
        btnSub.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnSub.setBounds(208, 142, 56, 60);
        frame.getContentPane().add(btnSub);
        
        // --- Row 3 (4, 5, 6, *) ---
        JButton btn4 = new JButton("4"); btn4.addActionListener(numListener);
        btn4.setFont(new Font("Tahoma", Font.BOLD, 18));
        btn4.setBounds(10, 213, 56, 60);
        frame.getContentPane().add(btn4);
        
        JButton btn5 = new JButton("5"); btn5.addActionListener(numListener);
        btn5.setFont(new Font("Tahoma", Font.BOLD, 18));
        btn5.setBounds(76, 213, 56, 60);
        frame.getContentPane().add(btn5);
        
        JButton btn6 = new JButton("6"); btn6.addActionListener(numListener);
        btn6.setFont(new Font("Tahoma", Font.BOLD, 18));
        btn6.setBounds(142, 213, 56, 60);
        frame.getContentPane().add(btn6);
        
        JButton btnMult = new JButton("*");
        btnMult.addActionListener(opListener);
        btnMult.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnMult.setBounds(208, 213, 56, 60);
        frame.getContentPane().add(btnMult);
        
        // --- Row 4 (1, 2, 3, /) ---
        JButton btn1 = new JButton("1"); btn1.addActionListener(numListener);
        btn1.setFont(new Font("Tahoma", Font.BOLD, 18));
        btn1.setBounds(10, 284, 56, 60);
        frame.getContentPane().add(btn1);
        
        JButton btn2 = new JButton("2"); btn2.addActionListener(numListener);
        btn2.setFont(new Font("Tahoma", Font.BOLD, 18));
        btn2.setBounds(76, 284, 56, 60);
        frame.getContentPane().add(btn2);
        
        JButton btn3 = new JButton("3"); btn3.addActionListener(numListener);
        btn3.setFont(new Font("Tahoma", Font.BOLD, 18));
        btn3.setBounds(142, 284, 56, 60);
        frame.getContentPane().add(btn3);
        
        JButton btnDiv = new JButton("/");
        btnDiv.addActionListener(opListener);
        btnDiv.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnDiv.setBounds(208, 284, 56, 60);
        frame.getContentPane().add(btnDiv);
        
        // --- Row 5 (0, ., =) ---
        JButton btn0 = new JButton("0"); btn0.addActionListener(numListener);
        btn0.setFont(new Font("Tahoma", Font.BOLD, 18));
        btn0.setBounds(10, 355, 56, 60);
        frame.getContentPane().add(btn0);
        
        JButton btnDot = new JButton(".");
        btnDot.addActionListener(e -> {
            if(!textField.getText().contains(".")) {
                textField.setText(textField.getText() + ".");
            }
        });
        btnDot.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnDot.setBounds(76, 355, 56, 60);
        frame.getContentPane().add(btnDot);
        
        JButton btnEqual = new JButton("=");
        btnEqual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String answer;
                if(!textField.getText().isEmpty()) {
                    secondNum = Double.parseDouble(textField.getText());
                    if (operation == "+") {
                        result = firstNum + secondNum;
                        answer = String.format("%.2f", result);
                        textField.setText(answer);
                    } else if (operation == "-") {
                        result = firstNum - secondNum;
                        answer = String.format("%.2f", result);
                        textField.setText(answer);
                    } else if (operation == "*") {
                        result = firstNum * secondNum;
                        answer = String.format("%.2f", result);
                        textField.setText(answer);
                    } else if (operation == "/") {
                        result = firstNum / secondNum;
                        answer = String.format("%.2f", result);
                        textField.setText(answer);
                    }
                }
            }
        });
        btnEqual.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnEqual.setBounds(142, 355, 122, 60);
        frame.getContentPane().add(btnEqual);
    }
}