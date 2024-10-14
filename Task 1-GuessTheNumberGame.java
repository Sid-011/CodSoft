import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random generator = new Random();

        System.out.println("Welcome to the Guess The Number Challenge!");

        int playerScore = 0;
        boolean continuePlaying = true;

        while (continuePlaying) {
            int secretNumber = generator.nextInt(200) + 1;
            int guessCount = 0;
            int maxTries = 5;

            System.out.println("I've thought of a number between 1 and 200. Can you figure it out?");

            while (guessCount < maxTries) {
                System.out.print("Your guess: ");
                int guessedNumber = input.nextInt();
                input.nextLine();

                guessCount++;

                if (guessedNumber == secretNumber) {
                    System.out.println("Well done! You nailed it! The number was " + secretNumber + ". You took " + guessCount + " tries.");
                    playerScore++;
                    break;
                } else if (guessedNumber < secretNumber) {
                    System.out.println("Oops, that's too low! Try again.");
                } else {
                    System.out.println("Too high! Give it another shot.");
                }
            }

            if (guessCount >= maxTries) {
                System.out.println("Out of luck! The number I was thinking of was " + secretNumber + ".");
            }

            System.out.print("Care for another round? (y/n): ");
            String userResponse = input.nextLine();
            continuePlaying = userResponse.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! Your total score is: " + playerScore);

        input.close();
    }
}
