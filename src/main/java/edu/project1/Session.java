package edu.project1;

public class Session {
    private final String answer;
    private char[] userAnswer;
    private final int maxAttempts;
    private int userAttempts;

    public Session(String answer, char[] userAnswer, int maxAttempts, int userAttempts) {
        this.answer = answer;
        this.userAnswer = userAnswer;
        this.maxAttempts = maxAttempts;
        this.userAttempts = userAttempts;
    }

    public char[] getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(char[] userAnswer) {
        this.userAnswer = userAnswer;
    }

    public int getUserAttempts() {
        return userAttempts;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public void setUserAttempts(int userAttempts) {
        this.userAttempts = userAttempts;
    }

    public String getAnswer() {
        return answer;
    }
}
