import java.util.Random;
import java.util.Scanner;

public class Main {

    final static Scanner x = new Scanner(System.in);
    final static Random rand = new Random();
    static int numberToGuess;
    static int guess;
    static int attempts = 0;

    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("Welcome To Number Guessing Game!");
        System.out.println("=================================");
        gameExecute();
    }


    public static void guessStart() {
        System.out.print("Enter Your Guess: ");
        guess = x.nextInt();
        attempts++;

        if (guess < numberToGuess) {
            System.out.println("Low! Try Again.");
        } else if (guess > numberToGuess) {
            System.out.println("High! Try Again.");
        } else {
            System.out.println("Correct! You Guessed It In " + attempts + " Tries!");
            retrycheck();
            return;
        }
        guessStart();
    }

    public static void retrycheck() {
        System.out.print("Do You Want To Play Again? (y/n): ");
        if (x.next().toLowerCase().charAt(0) != 'y') {
            System.out.println("Thanks For Playing!");
            x.close();
            return;
        }
        gameExecute();
    }

    public static void gameExecute() {
        if (attempts != 0) {
            System.out.println("=================================");
            System.out.println("New Round! Try to Beat Me Again.");
            System.out.println("=================================");
            attempts = 0;
        }
        numberToGuess = rand.nextInt(100) + 1;
        System.out.println("I have chosen a number between 1 and 100. Try to guess it!");
        guessStart();
    }

}
