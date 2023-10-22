package edu.project1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class Dictionary {
    public static final List<String> WORDS_FOR_SUCCESSFUL_GUESSING =
            Arrays.asList("Hit", "Great", "Nice", "Well done");
    private final List<String> wordForGuess =
            new ArrayList<>(Arrays.asList("black", "hello", "banana", "pineapple", "pigeon"));
    private final Random random = new Random();


    public String randomWord() {
        return wordForGuess.get(random.nextInt(wordForGuess.size()));
    }

    public void addNewWord(@NotNull String newWord) {
        if (newWord.length() == 1) {
            throw new IllegalArgumentException("Word is too short!");
        } else if (newWord.matches("^(.)\\1*$")) {
            throw new IllegalArgumentException("Word is not correct!");
        }
        wordForGuess.add(newWord.toLowerCase());
    }
}
