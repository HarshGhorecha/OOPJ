Parctical---> 3 
A(1).



import java.util.Scanner;

public class StudentDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Array to store marks of 5 subjects
        int[] marks = new int[5];
        int totalMarks = 0;
        
        // Input marks for 5 subjects
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }
        
        // Calculate percentage
        double percentage = (totalMarks / 5.0);
        
        // Determine the division
        String division;
        if (percentage >= 60) {
            division = "First Division";
        } else if (percentage >= 50) {
            division = "Second Division";
        } else if (percentage >= 40) {
            division = "Third Division";
        } else {
            division = "Fail";
        }
        
        // Output the percentage and division
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Division: " + division);
        
        scanner.close();
    }
}
