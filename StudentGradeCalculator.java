// Task 2 (Student Grade Calculator)
import java.util.*;
import java.util.Scanner;

public class StudentGradeCalculator {
public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
        
        // Input: Take marks obtained (out of 100) in each subject..
        System.out.print("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();
        int totalMarks = 0;

// Calculate Total Marks and input marks for each subject...
         for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks for Subject "+" :" + i + ": ");
            int marks = sc.nextInt();
            totalMarks += marks;
            
        }
        
        // Calculate Average Percentage...
        double averagePercentage = (double) totalMarks / numSubjects;
        
        // Grade Calculation:based on the average percentage ...
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        
        // Display Results
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    
    }
}



