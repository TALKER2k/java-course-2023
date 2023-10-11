package edu.project1;

public class GuessResult {
    private int userAttempts;
    private String resultMessage;

    public GuessResult(int userAttempts, String resultMessage) {
        this.userAttempts = userAttempts;
        this.resultMessage = resultMessage;
    }

    public int getUserAttempts() {
        return userAttempts;
    }

    public void setUserAttempts(int userAttempts) {
        this.userAttempts = userAttempts;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
