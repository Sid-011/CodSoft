import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many subjects do you have? ");
        int subjectCount = input.nextInt();
       
        int[] scores = new int[subjectCount];
        int totalScore = 0;
        
        for (int i = 0; i < subjectCount; i++) {
            System.out.print("Enter the score for Subject " + (i + 1) + " (out of 100): ");
            scores[i] = input.nextInt();
            totalScore += scores[i];
        }

        double avgPercentage = (double) totalScore / (subjectCount* 100) * 100;
    
        char finalGrade;
        if (avgPercentage >= 90) {
            finalGrade = 'A';
        } else if (avgPercentage >= 80) {
            finalGrade = 'B';
        } else if (avgPercentage >= 70) {
            finalGrade = 'C';
        } else if (avgPercentage >= 60) {
            finalGrade = 'D';
        } else {
            finalGrade = 'F';  
        }   
     
        System.out.println("\nYour Results:");
        System.out.println("Total Score: " + totalScore + " out of " + (subjectCount * 100));
        System.out.println("Average Percentage: " + avgPercentage + "%");
        System.out.println("Final Grade: " + finalGrade);
        
        input.close();
    }
}