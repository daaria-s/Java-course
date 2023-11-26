package edu.hw7;

import edu.hw7.Task3part2.Person;
import edu.hw7.Task3part2.PersonDatabase;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import java.util.concurrent.ThreadLocalRandom;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3part2Test {


    static Person[] persons = new Person[] {new Person(1, "Daria", "Moscow", "8888"),
        new Person(2, "Daniel", "Moscow", "9999"),
        new Person(3, "Artem", "Moscow", "7777"),
        new Person(4, "Sasha", "Moscow", "6666"),
        new Person(5, "Daria", "Moscow", "2222"),
        new Person(6, "Daniel", "Moscow", "8888"),
        new Person(7, "Artem", "SPB", "3333"),
        new Person(8, "Sasha", "SPB", "1111"),
        new Person(9, "Daria", "SPB", "2222"),
        new Person(10, "Daniel", "SPB", "0000"),
        new Person(11, "Artem", "SPB", "0101"),
        new Person(12, "Sasha", "SPB", "7777")};
    @Test
    void personDatabaseTestWithAdd() {

        PersonDatabase database = new PersonDatabase();

        Thread addingThread = getAddingThread(database);

        Thread checkFindThread = new Thread(() -> {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            var result = database.findByName("Daria");
            if (result != null) {
                for (Person p : result) {
                    assertTrue(database.findByAddress(p.address()).contains(p));
                    assertTrue(database.findByPhone(p.phoneNumber()).contains(p));
                    System.out.println("Check successful: " + p);

                }
            }

            result = database.findByPhone("9999");
            if (result != null) {
                for (Person p : result) {
                    assertTrue(database.findByAddress(p.address()).contains(p));
                    assertTrue(database.findByName(p.name()).contains(p));
                    System.out.println("Check successful: " + p);

                }
            }

            result = database.findByAddress("SPB");
            if (result != null) {
                for (Person p : result) {
                    assertTrue(database.findByName(p.name()).contains(p));
                    assertTrue(database.findByPhone(p.phoneNumber()).contains(p));
                    System.out.println("Check successful: " + p);

                }
            }
        });

        addingThread.start();
        checkFindThread.start();

        try {
            addingThread.join();
            checkFindThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull private static Thread getAddingThread(PersonDatabase database) {

        Thread addingThread = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                database.add(persons[ThreadLocalRandom.current().nextInt(persons.length)]);
            }
        });
        return addingThread;
    }
}
