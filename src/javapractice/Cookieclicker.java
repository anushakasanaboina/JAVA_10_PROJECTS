package javapractice;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Cookieclicker {

    public static void main(String[] args) {
       JFrame frame=new JFrame("cookie clicker");
       frame.setSize(400,400);
       frame.setLayout(null);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       JLabel heading=new JLabel("COOKIE CLICKED");
       heading.setBounds(100,10,300,40);
       heading.setFont(new Font("arial",Font.BOLD,20));
       frame.add(heading);
       
       JLabel countlbl=new JLabel("count:0");
       
       countlbl.setBounds(140,60,200,40);
       countlbl.setFont(new Font("arial",Font.BOLD,20));
       frame.add(countlbl);
       
       
       ImageIcon cookieimg=new ImageIcon("cookie.png");
       JButton cookiebtn=new JButton(cookieimg);
       cookiebtn.setBounds(100, 120, 200, 200);
       frame.add(cookiebtn);
       
       JLabel funlbl = new JLabel("");
       funlbl.setBounds(140, 330, 200, 40); // moved below the cookie button
       funlbl.setFont(new Font("Arial", Font.PLAIN, 16));
       frame.add(funlbl);
       
       int[] count= {0};
       cookiebtn.addActionListener(new ActionListener(){
    	   @Override
    	   public void actionPerformed(ActionEvent e) {
    		   count[0]++;
    		   countlbl.setText("count:"+count[0]);
    		   if (count[0] % 10 == 0) {  
    			    funlbl.setText("hey hey....");  
    			}else {
    				funlbl.setText(" ");
    			}

    	   }
    	   
       });
       
        
       frame.setVisible(true);
    }
}
