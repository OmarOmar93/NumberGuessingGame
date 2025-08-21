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
        while (true) {
            System.out.print("Enter Your Guess: ");
            guess = x.nextInt();
            attempts++;

            if (calculatePercentage(guess) == -1) {
                System.out.println("Correct! You Guessed It In " + attempts + " Tries!");
                retrycheck();
                break;
            }
        }
    }

    public static int calculatePercentage(final int guess) {
        if (numberToGuess == 0) return 0;

        int percentage = 100 - (int) ((Math.abs(guess - numberToGuess) / (double) numberToGuess) * 100);

        if (percentage < 0) percentage = 0;
        if (percentage > 100) percentage = 100;

        if (percentage == 100) {
            return -1;
        } else if (percentage >= 90) {
            System.out.println("Very close!");
        } else if (percentage >= 75) {
            System.out.println("Close!");
        } else if (percentage >= 50) {
            System.out.println("Not too far.");
        } else {
            System.out.println("Way off!");
        }

        return percentage;
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
