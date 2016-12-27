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
            try {
                isHit = game.applyGuess(guessInput);
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

    public void displayOutcome() {
        if (game.isWon()) {
            System.out.printf("Congratulations you found the word : %s%n", game.getAnswer());
        } else {
            System.out.printf("Oups! Sorry you could't find the word : %s.  :( Better luck next time%n", game.getAnswer());
        }
    }
}
