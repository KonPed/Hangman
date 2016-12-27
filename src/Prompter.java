import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by konstantinos on 12/26/2016.
 */
public class Prompter {
    private Game game;
    BufferedReader br;

    public Prompter(Game game) {
        this.game = game;
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public boolean promptForGuess() {
        char guess = 0;
        System.out.println("Enter a letter ");
        try {
            String guessInput = br.readLine();
            guess = guessInput.charAt(0);
        } catch (IOException | IndexOutOfBoundsException e) {
            System.out.println("Wow " + e.getMessage());
        }
        return game.applyGuess(guess);
    }
}
