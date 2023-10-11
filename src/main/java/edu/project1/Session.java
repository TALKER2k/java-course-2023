package edu.project1;

public class Session {
    private String answer;
    private char[] userAnswer;
    private final int maxAttempts;
    private final GuessResult userResult;

    public Session(String answer, char[] userAnswer, int maxAttempts, GuessResult userResult) {
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

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public String getAnswer() {
        return answer;
    }
}
