/**
 * Created by konstantinos on 12/26/2016.
 */
public class Hangman {
    public static void main(String[] args) {
        Game game = new Game("treehouse");
        Prompter prompter = new Prompter(game);
        prompter.display();
        if(prompter.promptForGuess()) {
            System.out.println("We got a hit");
        } else {
            System.out.println("Sorry, that was wrong");
        }
        prompter.display();
    }
}
