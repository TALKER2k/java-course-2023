package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public class Task3 {
    private final DateParserChainBuilder parserChain;

    public Task3() {
        this.parserChain = new DateParserChainBuilder();
    }

    public Optional<LocalDate> parseDate(String string) {
        return parserChain.parseDate(string);
    }
}

