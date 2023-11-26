package edu.hw7.Task3part2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PersonDatabase {

    private final ReadWriteLock lock = new ReentrantReadWriteLock(true);

    HashMap<Integer, Person> mapWithId = new HashMap<>();
    HashMap<String, ArrayList<Person>> mapWithName = new HashMap<>();
    HashMap<String, ArrayList<Person>> mapWithAddress = new HashMap<>();
    HashMap<String, ArrayList<Person>> mapWithPhone = new HashMap<>();

    public void add(Person person) {
        lock.writeLock().lock();
        try {
            mapWithId.put(person.id(), person);

            if (mapWithAddress.containsKey(person.address())) {
                mapWithAddress.get(person.address()).add(person);
            } else {
                mapWithAddress.put(person.address(), new ArrayList<>(List.of(person)));
            }

            if (mapWithName.containsKey(person.name())) {
                mapWithName.get(person.name()).add(person);
            } else {
                mapWithName.put(person.name(), new ArrayList<>(List.of(person)));
            }

            if (mapWithPhone.containsKey(person.phoneNumber())) {
                mapWithPhone.get(person.phoneNumber()).add(person);
            } else {
                mapWithPhone.put(person.phoneNumber(), new ArrayList<>(List.of(person)));
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    private void delete(int id) {
        lock.writeLock().lock();
        try {
            if (mapWithId.containsKey(id)) {
                Person person = mapWithId.get(id);
                mapWithName.get(person.name()).remove(person);
                mapWithAddress.get(person.address()).remove(person);
                mapWithPhone.get(person.phoneNumber()).remove(person);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<Person> findByName(String name) {
        lock.readLock().lock();
        try {
            if (mapWithName.containsKey(name)) {
                return mapWithName.get(name);
            }
            return null;
        } finally {
            lock.readLock().lock();
        }
    }

    public List<Person> findByAddress(String address) {
        lock.readLock().lock();
        try {
            if (mapWithAddress.containsKey(address)) {
                return mapWithAddress.get(address);
            }
            return null;
        } finally {
            lock.readLock().unlock();
        }
    }

    public List<Person> findByPhone(String phone) {
        lock.readLock().lock();
        try {
            if (mapWithPhone.containsKey(phone)) {
                return mapWithPhone.get(phone);
            }
            return null;
        } finally {
            lock.readLock().unlock();
        }
    }

}
