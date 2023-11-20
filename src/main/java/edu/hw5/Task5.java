package edu.hw5;

public class Task5 {

    public boolean validateCarPlate(String plate) {
        return plate.matches("[A-Z]\\d{3}[A-Z]{2}\\d{3}");
    }
}
