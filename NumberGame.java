import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int attemptsLimit =5;
        int rounds = 0;
        int score = 0;

        do {
            int targetNumber = rd.nextInt(upperBound - lowerBound + 1);
            int userGuess;
            int attempts = 0;

            System.out.println("Round " + (rounds + 1) + ": Guess the number between " + lowerBound + " and " + upperBound);

            do {
                System.out.print("Enter your guess: ");
                userGuess = sc.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score += attempts;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

            } while (userGuess != targetNumber && attempts < attemptsLimit);

            if (attempts == attemptsLimit) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + targetNumber);
            }

            rounds++;

            System.out.print("Do you want to play again? (yes/no): ");
        } while (sc.next().equalsIgnoreCase("yes"));

        System.out.println("Game over. Your total score is: " + score);
        sc.close();
    }
}
