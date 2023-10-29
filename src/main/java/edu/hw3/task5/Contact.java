package edu.hw3.task5;

import java.util.Objects;

public class Contact {

    String name;
    String surname;

    public Contact(String name) {
        String[] splittedName = name.split(" ");
        if (splittedName.length > 0) {
            this.name = splittedName[0];
            if (splittedName.length == 2) {
                this.surname = splittedName[1];
            }
        }
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(surname, contact.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}

