package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Task3 {

    public Optional<LocalDate> parseDate(String line) {
        return parseDashDate(line);
    }

    private Optional<LocalDate> parseDashDate(String line) {
        try {
            if (!line.matches("\\d{1,4}-\\d{1,2}-\\d{1,2}")) {
                throw new Exception();
            }

            String[] parts = line.split("-");
            int yearLength = parts[0].length();
            int monthLength = parts[1].length();
            int dayLength = parts[2].length();

            DateTimeFormatter pattern = DateTimeFormatter
                    .ofPattern("y".repeat(yearLength) + "-" + "M".repeat(monthLength) + "-" + "d".repeat(dayLength));

            return Optional.of(LocalDate.parse(line, pattern));
        } catch (Exception e) {
            return parseSlashDate(line);
        }
    }

    private Optional<LocalDate> parseSlashDate(String line) {
        try {
            if (!line.matches("\\d{1,2}/\\d{1,2}/\\d{1,4}")) {
                throw new Exception();
            }

            String[] parts = line.split("/");
            int dayLength = parts[0].length();
            int monthLength = parts[1].length();
            int yearLength = parts[2].length();

            DateTimeFormatter pattern = DateTimeFormatter
                    .ofPattern("d".repeat(dayLength) + "/" + "M".repeat(monthLength) + "/" + "y".repeat(yearLength));

            return Optional.of(LocalDate.parse(line, pattern));
        } catch (Exception e) {
            return parseOneWordDate(line);
        }
    }

    private Optional<LocalDate> parseOneWordDate(String line) {
        try {
            if (!line.matches("\\w*")) {
                throw new Exception();
            }

            return switch (line) {
                case "tomorrow" -> Optional.of(LocalDate.now().plusDays(1));
                case "today" -> Optional.of(LocalDate.now());
                case "yesterday" -> Optional.of(LocalDate.now().minusDays(1));
                default -> throw new Exception();
            };
        } catch (Exception e) {
            return parseNDaysAgo(line);
        }
    }

    private Optional<LocalDate> parseNDaysAgo(String line) {
        try {
            if (!line.matches("\\d+ (day)s? ago")) {
                throw new Exception();
            }

            long days = Long.parseLong(line.split(" ")[0]);

            return Optional.of(LocalDate.now().minusDays(days));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
