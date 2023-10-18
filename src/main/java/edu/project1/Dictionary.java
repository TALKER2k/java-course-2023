package edu.project1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Dictionary {
    List<String> WORDS_FOR_SUCCESSFUL_GUESSING =
            new ArrayList<>(Arrays.asList("Hit", "Great", "Nice", "Well done"));
    List<String> WORDS_FOR_GUESS =
            new ArrayList<>(Arrays.asList("black", "hello", "banana", "pineapple", "pigeon"));
}
