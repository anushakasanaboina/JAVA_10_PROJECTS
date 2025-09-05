package javapractice;

import java.util.Random;
import java.util.Scanner;

public class Rockpaperscissors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//variables 
		//user input
		//computer input
		//logic
		//play again
		//good bye message
		
		Scanner sc=new Scanner(System.in);
		Random random=new Random();
		String[] choices= {"rock","paper","scissors"};
		String userinput;
		String computerinput;
		String playagain="yes";
		
		
		do {
		System.out.print("enter your choice(rock/paper/scissors):");
		userinput=sc.nextLine().toLowerCase();
		
		if(!userinput.equals("rock")&&!userinput.equals("paper")&&!userinput.equals("scissors")) {
		   System.out.println("Invalid choice!");
		   continue;
 
		}
		 
		computerinput=choices[random.nextInt(3)];
		System.out.println("computer choice:"+computerinput);
		
		if(userinput.equals(computerinput)) {
			System.out.println("its a tie");
		}
		else if((userinput.equals("rock")&&computerinput.equals("scissors"))||
				(userinput.equals("scissors")&&computerinput.equals("paper"))||
		     (userinput.equals("paper")&&computerinput.equals("rock"))) {
			System.out.println("you win!");
		}
		
		else {
			System.out.println("you lose!");
		}
		
		
		System.out.println("wanna play again(yes/no):");
		playagain=sc.nextLine();
		
		
		}while(playagain.equals("yes"));
		
		System.out.println("thank you for playing");
		
		
 
}}
