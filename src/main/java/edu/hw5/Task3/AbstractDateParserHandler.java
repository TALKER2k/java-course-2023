package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

abstract class AbstractDateParserHandler {
    protected AbstractDateParserHandler nextHandler;

    AbstractDateParserHandler(AbstractDateParserHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    AbstractDateParserHandler() {
    }

    abstract Optional<LocalDate> handleRequest(String input);

    public Optional<LocalDate> parse(String input) {
        Optional<LocalDate> handleRequest = handleRequest(input);

        if (handleRequest.isEmpty()) {
            if (nextHandler == null) {
                return Optional.empty();
            }
            return nextHandler.parse(input);
        } else {
            return handleRequest(input);
        }
    }

    public void setNextLogger(AbstractDateParserHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
