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
        System.out.println("Enter a letter: ");
        String guessInput = scanner.nextLine();
        char guess = guessInput.charAt(0);
        boolean isHit = false;
        try {
            isHit = game.applyGuess(guess);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return isHit;
    }

    public void display() {
        System.out.printf("You have %d tries left to solve %s%n", game.remainingTimes(),
                game.getCurrentProgress());
    }
}
