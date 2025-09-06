import java.util.Scanner;

public class StdGradeSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        int[] sub = new int[subjects];
        int total = 0;

        for (int i = 0; i < subjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            sub[i] = sc.nextInt();
            total += sub[i];
        }

        System.out.println("\nTotal Marks = " + total);

        double average = (double) total / subjects; // correct average
        System.out.println("Average = " + average);

        char grade;

        if (average >= 90) {
            grade = 'A';
        } else if (average >= 50) {
            grade = 'B';
        } else if (average >= 30) {
            grade = 'C';
        } else {
            grade = 'F'; // Fail
        }

        System.out.println("Your Grade is: " + grade);

        sc.close();
    }
}
