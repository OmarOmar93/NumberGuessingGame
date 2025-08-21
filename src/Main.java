import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        Random rand = new Random();
        boolean firstgame = true;

        while (true) {
            int numberToGuess = rand.nextInt(100) + 1;
            int guess;
            int attempts = 0;

            if (firstgame) {
                System.out.println("=================================");
                System.out.println("Welcome To Number Guessing Game!");
                System.out.println("=================================");
                firstgame = false;
            } else {
                System.out.println("=================================");
                System.out.println("New Round! Try to Beat Me Again.");
                System.out.println("=================================");
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("I have chosen a number between 1 and 100. Try to guess it!");

            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("Enter Your Guess: ");
                guess = x.nextInt();
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Low! Try Again.");
                } else if (guess > numberToGuess) {
                    System.out.println("High! Try Again.");
                } else {
                    System.out.println("Correct! You Guessed It In " + attempts + " Tries!");
                    break;
                }
            }

            System.out.print("Do You Want To Play Again? (y/n): ");
            char choice = x.next().toLowerCase().charAt(0);

            if (choice != 'y') {
                System.out.println("Thanks For Playing!");
                break; // exit the main loop
            }
        }

        x.close();
    }
}
