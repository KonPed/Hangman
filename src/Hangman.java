/**
 * Created by konstantinos on 12/26/2016.
 */
public class Hangman {
    public static void main(String[] args) {
        Game game = new Game("midnight");
        System.out.println(game.applyGuess('m'));
    }
}
