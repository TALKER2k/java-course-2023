package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

class DateFormatParser extends AbstractDateParserHandler {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    DateFormatParser() {}

    @Override
    public Optional<LocalDate> handleRequest(String input) {
        try {
            LocalDate date = LocalDate.parse(input, formatter);
            return Optional.of(date);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

}
