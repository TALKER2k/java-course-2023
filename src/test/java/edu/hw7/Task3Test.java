package edu.hw7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {

    private static final String NAME = "Nikita";
    private static final String ADDRESS = "Voronezh";
    private static final String PHONE_NUMBER = "+79009991122";

    @Test
    public void testPersonAvailability() {
        Task3.PersonDatabase personDatabase = new Task3.SynchronizedPersonDatabase();

        Task3.Person person = new Task3.Person(1, NAME, ADDRESS, PHONE_NUMBER);
        personDatabase.add(person);

        assertTrue(personDatabase.findByName(NAME).contains(person));
        assertTrue(personDatabase.findByAddress(ADDRESS).contains(person));
        assertTrue(personDatabase.findByPhone(PHONE_NUMBER).contains(person));
    }

    @Test
    public void testPersonNotAvailable() {
        Task3.PersonDatabase personDatabase = new Task3.SynchronizedPersonDatabase();

        Task3.Person person = new Task3.Person(2, NAME, ADDRESS, PHONE_NUMBER);
        personDatabase.add(person);

        personDatabase.delete(2);

        assertEquals(0, personDatabase.findByName(NAME).size());
        assertEquals(0, personDatabase.findByAddress(ADDRESS).size());
        assertEquals(0, personDatabase.findByPhone(PHONE_NUMBER).size());
    }
}
