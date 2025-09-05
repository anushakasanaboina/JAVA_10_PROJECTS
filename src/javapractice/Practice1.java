package javapractice;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Practice1 {


	public static void main(String[] args) {
		JFrame frame=new JFrame();
		frame.setSize(400,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
           
		 JLabel reglbl = new JLabel("User Registration Form");
	      reglbl.setBounds(60, 20, 300, 40); // x=50, y=20, width=300, height=40
	      reglbl.setFont(new Font("Arial", Font.BOLD, 20));
	      frame.add(reglbl);
	   // Name
	      JLabel namelbl = new JLabel("Name:");
	      namelbl.setBounds(20, 80, 100, 25);
	      frame.add(namelbl);

	      JTextField nametxt = new JTextField();
	      nametxt.setBounds(120, 80, 200, 25);
	      frame.add(nametxt);

	      // Email
	      JLabel emaillbl = new JLabel("Email:");
	      emaillbl.setBounds(20, 120, 100, 25);  // y increased
	      frame.add(emaillbl);

	      JTextField emailtxt = new JTextField();
	      emailtxt.setBounds(120, 120, 200, 25); // y increased
	      frame.add(emailtxt);

	      // Password (optional example)
	      JLabel passlbl = new JLabel("Password:");
	      passlbl.setBounds(20, 160, 100, 25);
	      frame.add(passlbl);

	      JTextField passtxt = new JTextField();
	      passtxt.setBounds(120, 160, 200, 25);
	      frame.add(passtxt);
	      
	      
	      JButton login = new JButton("Login");
	      login.setBounds(280, 200, 100, 30); // x=150, y=180, width=100, height=30
	      frame.add(login);
	      
	      JLabel infolbl = new JLabel();
	        infolbl.setBounds(20, 180, 350, 50);
	        frame.add(infolbl);

	        // ActionListener for login
	        login.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String name = nametxt.getText();
	                String email = emailtxt.getText();

	                // Show info in the label
	                infolbl.setText("Name: " + name + " | Email: " + email);
	            }
	        });

	        frame.setVisible(true);
	    }
	}