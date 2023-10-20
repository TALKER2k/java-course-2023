package edu.project1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GuessResult {
    private int userAttempts;
    private String resultMessage;

    public GuessResult(int userAttempts, String resultMessage) {
        this.userAttempts = userAttempts;
        this.resultMessage = resultMessage;
    }
}
