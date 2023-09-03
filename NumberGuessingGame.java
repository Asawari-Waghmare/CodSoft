import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Welcome to the Number Guessing Game!");
        boolean playAgain = true;
        int totalRounds = 0;
        int totalAttempts = 0;
        
        while (playAgain) {
            totalRounds++;
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            
            System.out.println("Round " + totalRounds + ": Guess a number between 1 and 100.");
            
            while (true) {
                try {
                    System.out.print("Your guess: ");
                    int userGuess = scanner.nextInt();
                    attempts++;
    
                    if (userGuess == numberToGuess) {
                        System.out.println("Congratulations! You guessed the number " + numberToGuess + " in " + attempts + " attempts.");
                        totalAttempts += attempts;
                        break;
                    } else if (userGuess < numberToGuess) {
                        System.out.println("Number is too low... Try again.");
                    } else {
                        System.out.println("Number is too high... Try again.");
                    }
    
                    if (attempts == 10) {
                        System.out.println("You've reached the maximum number of attempts. The correct number was " + numberToGuess);
                        break;
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Please enter a valid number.");
                    scanner.nextLine(); // Consume the invalid input..
                }
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }
        
        System.out.println("You played " + totalRounds + " rounds and took an average of " + (totalAttempts / (double)totalRounds) + " attempts per round. Thanks for playing!");
        
    
    }
}
