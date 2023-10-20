package edu.project1;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class Session {
    @NotNull
    private String answer;
    private char[] userAnswer;
    private final int maxAttempts;
    private final GuessResult userResult;

    public Session(@NotNull String answer, char[] userAnswer, int maxAttempts, GuessResult userResult) {
        this.answer = answer;
        this.userAnswer = userAnswer;
        this.maxAttempts = maxAttempts;
        this.userResult = userResult;
    }

    public boolean isActiveSession() {
        return getMaxAttempts() - getUserResult().getUserAttempts() > 0;
    }
}
