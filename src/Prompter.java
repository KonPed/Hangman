import java.util.Scanner;

/**
 * Created by konstantinos on 12/26/2016.
 */
public class Prompter {
    private Game game;

    public Prompter(Game game) {
        this.game = game;
    }

    public boolean promptForGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        String guessInput = scanner.next();
        char guess = guessInput.charAt(0);
        return game.applyGuess(guess);
    }
}
