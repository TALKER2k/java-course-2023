package edu.project1;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class Session {
    @NotNull
    private String answer;
    private StringBuilder encryptedAnswer;
    private char[] userAnswer;
    private int maxAttempts;
    private int userAttempts;
    private Dictionary dictionary = new Dictionary();

    public Session() {
        this.answer = dictionary.randomWord();
        this.encryptedAnswer = encryptedAnswer(new StringBuilder(answer));
    }

    public Session(int maxAttempts) {
        this.answer = dictionary.randomWord();
        this.encryptedAnswer = encryptedAnswer(new StringBuilder(answer));
        this.maxAttempts = maxAttempts;
    }

    private StringBuilder encryptedAnswer(StringBuilder answer) {
        for (int i = 0; i < answer.length(); i++) {
            answer.setCharAt(i, '*');
        }
        return answer;
    }

    public boolean isAnswerNotGuess() {
        return !answer.equals(String.valueOf(encryptedAnswer));
    }

    public int tryGuess(char userChar) {
        int countGuess = 0;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == userChar) {
                encryptedAnswer.setCharAt(i, userChar);
                countGuess++;
            }
        }

        return countGuess;
    }

    public boolean isWin() {
        return answer.equals(String.valueOf(encryptedAnswer));
    }

    public boolean isDefeat() {
        return maxAttempts == userAttempts;
    }
}
