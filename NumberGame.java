
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Select difficulty level
        System.out.println("Select difficulty level: Easy, Medium, Hard");
        String difficulty = scanner.nextLine().toLowerCase();
        int upperBound = getUpperBound(difficulty);

        // Generate random number
        int generatedNumber = random.nextInt(upperBound) + 1;
        int totalPoints = 0;
        int maxChances = 3;

        for (int i = 0; i < maxChances; i++) {
            System.out.print("Enter a number between 1 and " + upperBound + " (Chance " + (i + 1) + "): ");
            int userInput = scanner.nextInt();

            if (userInput < 1 || userInput > upperBound) {
                System.out.println("Invalid input. Please enter a number between 1 and " + upperBound + ".");
                i--;
                continue;
            }

            int difference = Math.abs(generatedNumber - userInput);
            int points = calculatePoints(difference);
            totalPoints += points;

            System.out.println(getFeedback(points));

            if (difference != 0) {
                giveHint(generatedNumber, userInput);
            }
        }

        System.out.println("The generated number was: " + generatedNumber);
        System.out.println("Your total points: " + totalPoints);
        System.out.println(getFinalFeedback(totalPoints));
    }

    private static int getUpperBound(String difficulty) {
        switch (difficulty) {
            case "medium":
                return 100;
            case "hard":
                return 200;
            default:
                return 50; // Easy by default
        }
    }

    private static int calculatePoints(int difference) {
        if (difference == 0) {
            return 100;
        } else if (difference <= 10) {
            return 50;
        } else if (difference <= 20) {
            return 20;
        } else {
            return 0;
        }
    }

    private static String getFeedback(int points) {
        if (points == 100) {
            return "Perfect! Like Thor with Mjolnir!";
        } else if (points == 50) {
            return "Almost there! Channel your inner Iron Man!";
        } else if (points == 20) {
            return "Good effort! Like Captain America, you never give up!";
        } else {
            return "Keep trying! Even Hulk needed to smash a few times!";
        }
    }

    private static void giveHint(int generatedNumber, int userInput) {
        if (userInput < generatedNumber) {
            System.out.println("Hint: Try a higher number!");
        } else {
            System.out.println("Hint: Try a lower number!");
        }
    }

    private static String getFinalFeedback(int totalPoints) {
        if (totalPoints == 300) {
            return "You're the ultimate Avenger! Perfect score!";
        } else if (totalPoints >= 150) {
            return "You're a superhero in the making! Great job!";
        } else if (totalPoints >= 50) {
            return "You have the heart of a hero! Good effort!";
        } else {
            return "Even heroes have off days. Try again and unleash your inner hero!";
        }
    }
}