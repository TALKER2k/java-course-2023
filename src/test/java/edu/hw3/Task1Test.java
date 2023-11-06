package edu.hw3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @ParameterizedTest
    @CsvSource({
            "Hello world!, Svool dliow!",
            "Any fool can write code that a computer"
                    + " can understand. Good programmers write code that humans can understand."
                    + " ― Martin Fowler, Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw."
                    + " Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi",
            "12345, 12345",
            "@#$%, @#$%"
    })
    void stringEncodingTest(String input, String expected) {
        StringBuilder encodingString = Task1.encodeAtbash(input);

        assertThat(encodingString.toString()).isEqualTo(expected);
    }
}
