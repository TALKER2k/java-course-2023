package edu.project1;

import org.jetbrains.annotations.NotNull;

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

    public char[] getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(char[] userAnswer) {
        this.userAnswer = userAnswer;
    }

    public GuessResult getUserResult() {
        return userResult;
    }

    public void setAnswer(@NotNull String answer) {
        this.answer = answer;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public @NotNull String getAnswer() {
        return answer;
    }

    public boolean isActiveSession() {
        return getMaxAttempts() - getUserResult().getUserAttempts() > 0;
    }
}
