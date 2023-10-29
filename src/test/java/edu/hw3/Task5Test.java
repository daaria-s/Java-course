package edu.hw3;

import edu.hw3.task5.Contact;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static edu.hw3.task5.ParseContacts.parseContacts;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task5Test {

    @Test
    void ContactsWithSurnamesTest() {

        Contact[] testListOfContacts =
            new Contact[] {new Contact("Thomas Aquinas"), new Contact("Rene Descartes"), new Contact("David Hume"),
                new Contact("John Locke")};

        assertArrayEquals(
            testListOfContacts,
            parseContacts(new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"}, "ASC")
        );

        Collections.reverse(Arrays.asList(testListOfContacts));
        assertArrayEquals(
            testListOfContacts,
            parseContacts(new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"}, "DESC")
        );
    }

    @Test
    void ContactsWithoutSurnamesTest() {

        Contact[] testListOfContacts =
            new Contact[] {new Contact("Thomas Aquinas"), new Contact("David"), new Contact("John Locke"),
                new Contact("Rene")};

        assertArrayEquals(
            testListOfContacts,
            parseContacts(new String[] {"John Locke", "Thomas Aquinas", "David", "Rene"}, "ASC")
        );

        Collections.reverse(Arrays.asList(testListOfContacts));
        assertArrayEquals(
            testListOfContacts,
            parseContacts(new String[] {"John Locke", "Thomas Aquinas", "David", "Rene"}, "DESC")
        );

    }

    @Test
    void EmptyListTest() {
        assertArrayEquals(new Contact[0], parseContacts(new String[0], "ASC"));
        assertArrayEquals(new Contact[0], parseContacts(new String[0], "DESC"));
    }
}
