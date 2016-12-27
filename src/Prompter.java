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
        boolean isHit = false;
        boolean isAcceptable = false;
        do {
            System.out.println("Enter a letter: ");
            String guessInput = scanner.nextLine();
            char guess = guessInput.charAt(0);
            try {
                isHit = game.applyGuess(guess);
                isAcceptable = true;
            } catch (IllegalArgumentException e) {
                System.out.printf("%s. Please try again. %n", e.getMessage());
            }
        } while (!isAcceptable);
        return isHit;
    }

    public void display() {
        System.out.printf("You have %d tries left to solve %s%n", game.remainingTimes(),
                game.getCurrentProgress());
    }
}
