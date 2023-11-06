package edu.hw3;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SuppressWarnings("checkstyle:MultipleStringLiterals")
public class Task5Test {
    private  static final List<String> INPUT_CONTACTS = new ArrayList<>(List
            .of("John Locke", "Aquinas", "David Hume", "Rene Descartes"));
    private  static final List<String> OUTPUT_CONTACTS_ASC = new ArrayList<>(List
            .of("Aquinas", "Rene Descartes", "David Hume", "John Locke"));
    private  static final List<String> OUTPUT_CONTACTS_DESC = new ArrayList<>(List
            .of("John Locke", "David Hume", "Rene Descartes", "Aquinas"));
    private  static final List<String> INPUT_CONTACTS_SECOND = new ArrayList<>(List
            .of("Carl Gauss", "Leonhard Euler", "Paul Erdos"));
    private  static final List<String> OUTPUT_CONTACTS_SECOND_ASC = new ArrayList<>(List
            .of("Paul Erdos", "Leonhard Euler", "Carl Gauss"));
    private  static final List<String> OUTPUT_CONTACTS_SECOND_DESC = new ArrayList<>(List
            .of("Carl Gauss", "Leonhard Euler", "Paul Erdos"));

    @Test
    void parseContactsTest() {
        List<String> resultContactsAsc;
        List<String> resultContactsDesc;
        List<String> resultContactsSecondAsc;
        List<String> resultContactsSecondDesc;

        resultContactsAsc = Task5.parseContacts(INPUT_CONTACTS, Task5.ASC);
        resultContactsDesc = Task5.parseContacts(INPUT_CONTACTS, Task5.DESC);
        resultContactsSecondAsc = Task5.parseContacts(INPUT_CONTACTS_SECOND, Task5.ASC);
        resultContactsSecondDesc = Task5.parseContacts(INPUT_CONTACTS_SECOND, Task5.DESC);

        assertThat(resultContactsAsc).isEqualTo(OUTPUT_CONTACTS_ASC);
        assertThat(resultContactsDesc).isEqualTo(OUTPUT_CONTACTS_DESC);
        assertThat(resultContactsSecondAsc).isEqualTo(OUTPUT_CONTACTS_SECOND_ASC);
        assertThat(resultContactsSecondDesc).isEqualTo(OUTPUT_CONTACTS_SECOND_DESC);
    }

    @Test
    void badInputParseContactsTest() {
        List<String> resultContactsAsc;
        List<String> resultContactsDesc;

        resultContactsAsc = Task5.parseContacts(null, Task5.ASC);
        resultContactsDesc = Task5.parseContacts(List.of(), Task5.ASC);

        assertThat(resultContactsAsc).isEqualTo(List.of());
        assertThat(resultContactsDesc).isEqualTo(List.of());
    }
}
