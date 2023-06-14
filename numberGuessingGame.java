package internship;

import java.util.Scanner;

public class numberGuessingGame {
	public static void main(String[] args) {
        final int Max_Attempts = 10;
        final int MAX_NUMBER = 100;
        final int MIN_NUMBER = 1;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Guess the Number game!");

        Scanner scanner = new Scanner(System.in);

        while (playAgain) {
            int secretNumber = (int) (Math.random() * (MAX_NUMBER - MIN_NUMBER + 1)) + MIN_NUMBER;
            int attempts = 0;
            boolean hasWon = false;

            while (!hasWon && attempts < Max_Attempts) {
                System.out.print("Enter your guess: ");
                int playerGuess = scanner.nextInt();
                attempts++;

                if (playerGuess == secretNumber) {
                    hasWon = true;
                    score += Max_Attempts - attempts + 1;
                    System.out.println("Congratulations! You've guessed the number correctly.");
                    System.out.println("You took " + attempts + " attempts.");
                    System.out.println("Current score: " + score);
                } else if (playerGuess < secretNumber) {
                    System.out.println("Your Guessing is Too low! Try again.");
                } else {
                    System.out.println("Your Guessing is Too high! Try again.");
                }
            }

            if (!hasWon) {
                System.out.println("You have reached the maximum number of attempts.");
                System.out.println("The secret number was: " + secretNumber);
            }

            System.out.print("Do you want to play again? (Y/N): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("Y");
        }

        System.out.println("Game over!! Your final score is: " + score);
        scanner.close();
    }
}
