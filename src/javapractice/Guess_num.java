import java.util.Scanner;


public class Guess_num {
     public static void main(String[] args){
        int mynumber=(int)(Math.random()*100);
        int usernumber=0;
        Scanner sc=new Scanner(System.in);
        do{
           System.out.println("guess my number:");
           usernumber=sc.nextInt();
           if(usernumber==mynumber){
            System.out.println("wow.....your correct");
            break;
           }
           else if(usernumber<mynumber){
              System.out.println("your number is too small..");
           }
           else{
            System.out.println("your number is too big");
           }
        }while(usernumber>0);
        System.out.print("my number was:");
        System.out.println(mynumber);

    }
}
