import java.util.Scanner;

public class HiddenWord {

    private String correctWord;
    // private String guessWord;
    
    public HiddenWord(String correctWord) {
        this.correctWord = correctWord;
    }

    public String getHint(String guessWord) {
        String hint = "";

        // System.out.println(correctWord);
        // System.out.println(guessWord);

        for (int i = 0; i < guessWord.length(); i++) {
            if (inCorrectSpot(i, guessWord)) {
                hint += correctWord.substring(i, i+1);
            } else if (!(inCorrectSpot(i, guessWord)) && inString(i, guessWord)) {
                hint += "+";
            } else {
                hint += "*";
            }
        }

        return hint;
    }

    public boolean inCorrectSpot(int i, String guessWord) {



        if (guessWord.substring(i, i+1).equals(correctWord.substring(i, i+1))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean inString(int i, String guessWord) {
        int total = 0;

        for (int j = 0; j < guessWord.length(); j++) {
            if (guessWord.substring(i, i+1).equals(correctWord.substring(j, j+1))) {
                total = 1;
                return true;
            }
        }

        if (total == 1) {
            return true;
        } else {
            return false;
        }
    }

}