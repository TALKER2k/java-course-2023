package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public final class Task1 {

    public String getStringAverageDuration(List<String> lines) {
        Duration totalDuration = Duration.ZERO;

        for (String line : lines) {
            totalDuration = totalDuration.plus(getDuration(line));
        }

        totalDuration = totalDuration.dividedBy(lines.size());

        long hours = totalDuration.toHours();
        final int minutesPerHour = 60;
        long minutes = totalDuration.toMinutes() - totalDuration.toHours() * minutesPerHour;

        return hours + "h " + minutes + "m";
    }

    private Duration getDuration(String line) {
        if (!line.matches("\\d{4}-\\d{2}-\\d{2}, \\d{2}:\\d{2} - \\d{4}-\\d{2}-\\d{2}, \\d{2}:\\d{2}")) {
            throw new IllegalArgumentException("Illegal line");
        }

        String[] borders = line.split(" - ");

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

        LocalDateTime start = LocalDateTime.parse(borders[0], pattern);
        LocalDateTime end = LocalDateTime.parse(borders[1], pattern);

        return Duration.between(start, end);
    }
}
