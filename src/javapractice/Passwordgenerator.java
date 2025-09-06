package javapractice;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Passwordgenerator {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Password Generator");
        frame.setLayout(null);
        frame.setSize(400, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel("PASSWORD GENERATOR");
        heading.setBounds(70, 10, 300, 50);
        heading.setFont(new Font("arial", Font.BOLD, 20));
        frame.add(heading);

        JLabel passlength = new JLabel("Password length:");
        passlength.setBounds(20, 70, 150, 50);
        passlength.setFont(new Font("arial", Font.BOLD, 15));
        frame.add(passlength);

        JTextField input = new JTextField();
        input.setBounds(170, 80, 200, 30);
        frame.add(input);

        JToggleButton upperBtn = new JToggleButton("Uppercase");
        JToggleButton lowerBtn = new JToggleButton("Lowercase");
        JToggleButton numberBtn = new JToggleButton("Numbers");
        JToggleButton symbolBtn = new JToggleButton("Symbols");

        upperBtn.setBounds(30, 140, 120, 40);
        lowerBtn.setBounds(210, 140, 120, 40);
        numberBtn.setBounds(30, 190, 120, 40);
        symbolBtn.setBounds(210, 190, 120, 40);

        frame.add(upperBtn);
        frame.add(lowerBtn);
        frame.add(numberBtn);
        frame.add(symbolBtn);

        JButton generatebtn = new JButton("GENERATE");
        generatebtn.setBounds(100, 260, 150, 50);
        frame.add(generatebtn);

        JTextField outputpass = new JTextField();
        outputpass.setBounds(70, 340, 200, 30);
        frame.add(outputpass);

        // COPY button
        JButton copyBtn = new JButton("COPY");
        copyBtn.setBounds(280, 340, 80, 30);
        frame.add(copyBtn);

        generatebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int length = Integer.parseInt(input.getText());

                    // Check positive length
                    if (length <= 0) {
                        outputpass.setText("Enter a positive number!");
                        return;
                    }

                    // Optional: max length
                    if (length > 50) {
                        outputpass.setText("Max length 50!");
                        return;
                    }

                    String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    String lower = "abcdefghijklmnopqrstuvwxyz";
                    String numbers = "0123456789";
                    String symbols = "!@#$%^&*()-_=+<>?";

                    StringBuilder pool = new StringBuilder();
                    StringBuilder password = new StringBuilder();

                    if (upperBtn.isSelected()) pool.append(upper);
                    if (lowerBtn.isSelected()) pool.append(lower);
                    if (numberBtn.isSelected()) pool.append(numbers);
                    if (symbolBtn.isSelected()) pool.append(symbols);

                    // Check if at least one character type is selected
                    if (pool.length() == 0) {
                        outputpass.setText("Select at least one character type!");
                        return;
                    }

                    ArrayList<String> set = new ArrayList<>();
                    if (upperBtn.isSelected()) set.add(upper);
                    if (lowerBtn.isSelected()) set.add(lower);
                    if (numberBtn.isSelected()) set.add(numbers);
                    if (symbolBtn.isSelected()) set.add(symbols);

                    // Check if length >= number of selected sets
                    if (length < set.size()) {
                        outputpass.setText("Length must be ≥ selected types!");
                        return;
                    }

                    // Guarantee at least one character from each selected type
                    for (String s : set) {
                        int index = (int) (Math.random() * s.length());
                        password.append(s.charAt(index));
                    }

                    // Fill remaining characters
                    while (password.length() < length) {
                        int index = (int) (Math.random() * pool.length());
                        password.append(pool.charAt(index));
                    }

                    // Shuffle password
                    char[] chars = password.toString().toCharArray();
                    for (int i = chars.length - 1; i > 0; i--) {
                        int j = (int) (Math.random() * (i + 1));
                        char temp = chars[i];
                        chars[i] = chars[j];
                        chars[j] = temp;
                    }

                    outputpass.setText(new String(chars));

                } catch (NumberFormatException ex) {
                    outputpass.setText("Enter valid number");
                }
            }
        });

        // Copy button functionality
        copyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = outputpass.getText();
                if (!password.isEmpty() && !password.startsWith("Enter") && !password.startsWith("Select")) {
                    StringSelection selection = new StringSelection(password);
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(selection, null);
                    outputpass.setText(password + " (copied!)");
                }
            }
        });

        frame.setVisible(true);
    }
}
