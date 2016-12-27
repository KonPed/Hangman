/**
 * Created by konstantinos on 12/26/2016.
 */
public class Game {

    private String answer;
    private String hits;
    private String misses;

    public Game(String answer) {
        this.answer = answer;
        hits = "";
        misses = "";
    }

    public boolean applyGuess(char letter) {
        boolean validGuess = (answer.indexOf(letter) != -1);
        if (validGuess) {
            hits += letter;
        } else {
            misses += letter;
        }
        return validGuess;
    }

    public String getCurrentProgress() {
        String progress = "";
        for (char letter : answer.toCharArray()) {
            char display = '-';
            if (hits.indexOf(letter) != -1) {
                display = letter;
            }
            progress += display;
        }
        return progress;
    }
}
