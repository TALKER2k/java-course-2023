package edu.hw5;

public class Task4 {

    public boolean validatePassword(String password) {
        return password.matches(".*[~!@#/$%^&*|].*");
    }
}
