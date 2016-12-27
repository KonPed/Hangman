import java.util.Scanner;

/**
 * Created by konstantinos on 12/26/2016.
 */
public class Hangman {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: type java Hangman and then the <answer> || set the answer through IDE's program arguments");
            System.out.println("HAVE FUN!!!");
            System.err.println("answer is required");
            System.err.println("Set the answer in the program arguments");
            System.exit(1);
        }
        Game game = new Game(args[0]);
        Prompter prompter = new Prompter(game);
        while (game.remainingTimes() != 0 && !game.isWon()) {
            prompter.display();
            if (prompter.promptForGuess()) {
                System.out.println("We got a hit");
            } else {
                System.out.println("Sorry, that was wrong");
            }
        }
        prompter.displayOutcome();
    }
}
