import java.util.Scanner;

public class virat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input: Take marks obtained (out of 100) in each subject
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        int[] marks = new int[numSubjects];
        
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
        
        
        int totalMarks = calculateTotalMarks(marks);
        
    
        double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);
        
        
        String grade = calculateGrade(averagePercentage);
        
        
        displayResults(totalMarks, averagePercentage, grade);
        
        scanner.close();
    }
    
    private static int calculateTotalMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }
    
    private static double calculateAveragePercentage(int totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;
    }
    
    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 80) {
            return "B";
        } else if (averagePercentage >= 70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
    
    private static void displayResults(int totalMarks, double averagePercentage, String grade) {
        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }
}
