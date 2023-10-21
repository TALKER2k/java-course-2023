package edu.project1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DictionaryTest {

    @Test
    void getRandomWordTest() {
        Dictionary dictionary = new Dictionary();

        String word = dictionary.randomWord();

        assertThat(dictionary.getWordForGuess()).asList().contains(word);
    }

    @Test
    void addNewWordTest() {
        Dictionary dictionary = new Dictionary();
        String newWord = "computer";

        dictionary.addNewWord(newWord);

        assertThat(dictionary.getWordForGuess()).asList().contains(newWord);
    }
}
