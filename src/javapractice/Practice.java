
package javapractice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Practice{
	public static void main(String[] args) {
		JFrame frame=new JFrame();
		frame.setLayout(null);
		 frame.setSize(400, 300);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 frame.setTitle("Rock_Paper_Scissors");
		 
		 
		 JLabel userchoice=new JLabel("user choice:");
		 userchoice.setBounds(20, 50, 120, 30);
		 frame.add(userchoice);
		 
		 JLabel computerlabel=new JLabel("computer choice:");
		 computerlabel.setBounds(160, 50, 150, 30);
		 frame.add(computerlabel);
		 
		 
		 JButton rockbtn = new JButton("Rock");
		 rockbtn.setBounds(20, 120, 100, 30);   // x=50, y=120
		 frame.add(rockbtn);

		 JButton paperbtn = new JButton("Paper");
		 paperbtn.setBounds(130, 120, 100, 30); // x=160, y=120
		 frame.add(paperbtn);

		 JButton scissorsbtn = new JButton("Scissors");
		 scissorsbtn.setBounds(250, 120, 100, 30); // x=270, y=120
		 frame.add(scissorsbtn);
		 
		 
		 
		 JLabel resultlabel=new JLabel("result:");
		 resultlabel.setBounds (130, 180, 150, 30);
		 frame.add(resultlabel);
		 
		 
		 String[] choices= {"rock","paper","scissors"};		
		 Random random=new Random();
		 
		 ActionListener listener = new ActionListener() {
			 @Override
	            public void actionPerformed(ActionEvent e) {
				 String playermove="";
				 if(e.getSource()==rockbtn)playermove="rock";
				 else if(e.getSource()==paperbtn)playermove="paper";
				 else if (e.getSource() == scissorsbtn) playermove = "scissors";

				 
				 
				 String computermove=choices[random.nextInt(3)];
				 
				 userchoice.setText("user choice:"+playermove);
				 computerlabel.setText("computer choice:"+computermove);
				 
				 
				 //logic
				 
				 if(playermove.equals(computermove)) {
					 resultlabel.setText("its a tie");
				 }
				 else if((playermove.equals("rock")&&computermove.equals("scissors"))||
						 (playermove.equals("scissors")&&computermove.equals("paper"))||
						 (playermove.equals("paper")&&computermove.equals("rock")))
						 {
				             resultlabel.setText("you win!");
			          }
				 else {
					 resultlabel.setText("you lose!");
				 }
				 
				 
				 
			 
         }
     };

     rockbtn.addActionListener(listener);
     paperbtn.addActionListener(listener);
     scissorsbtn.addActionListener(listener);

     frame.setVisible(true);
 }
}