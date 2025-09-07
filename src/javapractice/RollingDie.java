package javapractice;

import java.awt.Font;
import java.util.Random;
import javax.swing.*;

public class RollingDie {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rolling Die");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel heading = new JLabel("ROLLING DIE");
        heading.setBounds(120, 10, 300, 40);
        heading.setFont(new Font("arial", Font.BOLD, 22));
        frame.add(heading);

        // Player 1 label
        JLabel player1Label = new JLabel("Player 1");
        player1Label.setBounds(70, 60, 100, 30);
        player1Label.setFont(new Font("arial", Font.BOLD, 16));
        frame.add(player1Label);

        // Player 2 label
        JLabel player2Label = new JLabel("Player 2");
        player2Label.setBounds(230, 60, 100, 30);
        player2Label.setFont(new Font("arial", Font.BOLD, 16));
        frame.add(player2Label);

        // Dice images
        JLabel die1 = new JLabel(new ImageIcon("images/dice1.png"));
        die1.setBounds(50, 100, 100, 100);
        frame.add(die1);

        JLabel die2 = new JLabel(new ImageIcon("images/dice1.png"));
        die2.setBounds(220, 100, 100, 100);
        frame.add(die2);

        JButton roll = new JButton("ROLL");
        roll.setBounds(130, 250, 120, 40);
        roll.setFont(new Font("arial", Font.BOLD, 18));
        frame.add(roll);

        // Load dice images
        ImageIcon[] imageset = new ImageIcon[6];
        for (int i = 0; i < 6; i++) {
            imageset[i]=new ImageIcon(RollingDie.class.getResource("/images/dice"+(i+1)+".png"));
        }

        Random rnd = new Random();

        roll.addActionListener(e -> {
            int animationTime = 1500; // 1.5 seconds animation
            int delay = 100;          // change images every 100ms

            Timer timer = new Timer(delay, null);
            long start = System.currentTimeMillis();

            timer.addActionListener(ev -> {
                int r1 = rnd.nextInt(6);
                int r2 = rnd.nextInt(6);

                die1.setIcon(imageset[r1]);
                die2.setIcon(imageset[r2]);

                // Stop timer after animationTime
                if (System.currentTimeMillis() - start > animationTime) {
                    timer.stop();
                }
            });

            timer.start();
        });

        frame.setVisible(true);
    }
}
