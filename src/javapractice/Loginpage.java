package javapractice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



  

public class Loginpage implements ActionListener{
	
	  private static JTextField usertext;
	  private static JLabel label;
	  private static JLabel passlabel;
	  private static JPasswordField passwordtext;
	  private static JButton button;
	  private static   JLabel success;
	  
	  
	  
	  
	public static void main(String[] args) {
		
		JPanel panel=new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(300,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		
		
		panel.setLayout(null);
	     label=new JLabel("user:");
		label.setBounds(10, 20, 80, 25);
		panel.add(label);
		
	    usertext=new JTextField(20);
		usertext.setBounds(100, 20, 165, 25);
		panel.add(usertext);
		
		
		passlabel=new JLabel("password:");
		passlabel.setBounds(10, 50, 80, 25);
		panel.add(passlabel);
		
	    passwordtext=new JPasswordField(20);
		passwordtext.setBounds(100, 50, 165, 25);
		panel.add(passwordtext);
		
		
		button=new JButton("login");
		button.setBounds(10,80,80,25);
		button.addActionListener(new Loginpage());
		panel.add(button);
		
		success=new JLabel(" ");
		success.setBounds(10,100,150,25);
		panel.add(success);
		
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String user= usertext.getText();
		String password=passwordtext.getText();
		System.out.println(user + ","+password);
		if(user.equals("anusha")&&password.equals("anu@123")) {
			
			success.setText("login successfully");
		}else {
			success.setText("login failed");
		}
		
	}

}
