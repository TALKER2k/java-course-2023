package edu.hw4;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;

public class ValidationError extends RuntimeException {
    @Getter
    private final String message;
    final ValidationErrorName type;

    public enum ValidationErrorName {
        NAME, TYPE, SEX, AGE, HEIGHT, WEIGHT
    }

    public ValidationError(String message, ValidationErrorName type) {
        this.message = message;
        this.type = type;
    }

    public static Set<ValidationError> validateAnimal(Animal animal) {
        Set<ValidationError> exception = new HashSet<>();

        exception.addAll(errorName(animal));
        exception.addAll(errorType(animal));
        exception.addAll(errorSex(animal));
        exception.addAll(errorAge(animal));
        exception.addAll(errorHeight(animal));
        exception.addAll(errorWeight(animal));

        return exception;
    }

    private static Set<ValidationError> errorName(Animal animal) {
        Set<ValidationError> error = new HashSet<>();
        if (animal.name() == null || animal.name().isEmpty()) {
            error.add(new ValidationError("Name not be empty or null", ValidationErrorName.NAME));
        }

        return error;
    }

    private static Set<ValidationError> errorType(Animal animal) {
        Set<ValidationError> error = new HashSet<>();

        if (animal.type() == null) {
            error.add(new ValidationError("Type not be null", ValidationErrorName.TYPE));
        }

        return error;
    }

    private static Set<ValidationError> errorSex(Animal animal) {
        Set<ValidationError> error = new HashSet<>();

        if (animal.sex() == null) {
            error.add(new ValidationError("Sex not be null", ValidationErrorName.SEX));
        }

        return error;
    }

    private static Set<ValidationError> errorAge(Animal animal) {
        Set<ValidationError> error = new HashSet<>();

        if (animal.age() < 0) {
            error.add(new ValidationError("Age not be negative", ValidationErrorName.AGE));
        }

        return error;
    }

    private static Set<ValidationError> errorHeight(Animal animal) {
        Set<ValidationError> error = new HashSet<>();

        if (animal.height() < 0) {
            error.add(new ValidationError("Height not be negative", ValidationErrorName.HEIGHT));
        }

        return error;
    }

    private static Set<ValidationError> errorWeight(Animal animal) {
        Set<ValidationError> error = new HashSet<>();

        if (animal.weight() < 0) {
            error.add(new ValidationError("Weight not be negative", ValidationErrorName.WEIGHT));
        }

        return error;
    }
}
