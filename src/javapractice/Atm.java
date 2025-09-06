import java.util.Scanner;
public class Atm {
    public static void main(String args[]){
     Scanner sc=new Scanner(System.in);
     System.out.println("enter your budjet");
     int defaultbalance=sc.nextInt();
     
     int userchoice;
     do{
     System.out.println("1.check balance");
     System.out.println("2.Deposit Money");
     System.out.println("3.Withdraw Money");
     System.out.println("4.Exit");

     
     System.out.println("enter your choice:");
      userchoice=sc.nextInt();
     if(userchoice==1){
        System.out.println("your current balance is:"+defaultbalance);
     }
     else if(userchoice==2){
        System.out.println("enter the deposite amount:");
        int deposite=sc.nextInt();
        defaultbalance+=deposite;
         System.out.println("your current balance after deposite is:"+defaultbalance);

     }
     else if(userchoice==3){
        
       System.out.println("enter withdraw amount ");
       int withdraw=sc.nextInt();
       if(withdraw<=defaultbalance){
       defaultbalance=defaultbalance-withdraw;
       }else{
        System.out.println("not anough money");
       }
        System.out.println("your current balance after withdraw is:"+defaultbalance);
     }
     else{
        System.out.println("invalid choice,please try again..");
     }
    
    }while(userchoice!=4);

    System.out.println("THANKYOU FOR VISITING");






    }
}
