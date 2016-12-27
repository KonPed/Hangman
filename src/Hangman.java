
/**
 * Created by konstantinos on 12/26/2016.
 */
public class Hangman {
    public static void main(String[] args) {
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
