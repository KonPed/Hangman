/**
 * Created by konstantinos on 12/26/2016.
 */
public class Game {

    private String answer;
    private String hits;
    private String misses;
    public static final int MAX_MISSES = 7;

    public Game(String answer) {
        this.answer = answer.toLowerCase();
        hits = "";
        misses = "";
    }

    public boolean applyGuess(char letter) {
        letter = normalizeGuess(letter);
        boolean validGuess = (answer.indexOf(letter) != -1);
        if (validGuess) {
            hits += letter;
        } else {
            misses += letter;
        }
        return validGuess;
    }

    public boolean applyGuess(String letters) {
        if (letters.isEmpty()) {
            throw new IllegalArgumentException("No letter found");
        }
        return applyGuess(letters.charAt(0));
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

    private char normalizeGuess(char letter) {
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("A letter is required");
        }
        letter = Character.toLowerCase(letter);
        if (hits.indexOf(letter) != -1 || misses.indexOf(letter) != -1) {
            throw new IllegalArgumentException("Letter " + letter + " has already been guessed");
        }
        return letter;
    }

    public int remainingTimes() {
        return MAX_MISSES - misses.length();
    }
}
