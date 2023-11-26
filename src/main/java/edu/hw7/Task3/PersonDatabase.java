package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonDatabase {

    HashMap<Integer, Person> mapWithId = new HashMap<>();
    HashMap<String, ArrayList<Person>> mapWithName = new HashMap<>();
    HashMap<String, ArrayList<Person>> mapWithAddress = new HashMap<>();
    HashMap<String, ArrayList<Person>> mapWithPhone = new HashMap<>();

    enum Action {
        ADD, DELETE, FIND_BY_NAME, FIND_BY_ADDRESS, FIND_BY_PHONE
    }

    private void addInternal(Person person) {
        mapWithId.put(person.id(), person);

        if (mapWithName.containsKey(person.name())) {
            mapWithName.get(person.name()).add(person);
        } else {
            mapWithName.put(person.name(), new ArrayList<>(List.of(person)));
        }

        if (mapWithAddress.containsKey(person.address())) {
            mapWithAddress.get(person.address()).add(person);
        } else {
            mapWithAddress.put(person.address(), new ArrayList<>(List.of(person)));
        }

        if (mapWithPhone.containsKey(person.phoneNumber())) {
            mapWithPhone.get(person.phoneNumber()).add(person);
        } else {
            mapWithPhone.put(person.phoneNumber(), new ArrayList<>(List.of(person)));
        }
    }

    public void add(Person person) {
        doAction(Action.ADD, person);
    }

    private void deleteInternal(int id) {
        if (mapWithId.containsKey(id)) {
            Person person = mapWithId.get(id);
            mapWithName.get(person.name()).remove(person);
            mapWithAddress.get(person.address()).remove(person);
            mapWithPhone.get(person.phoneNumber()).remove(person);
        }
    }

    public void delete(int id) {
        doAction(Action.DELETE, id);
    }

    private List<Person> findByNameInternal(String name) {
        if (mapWithName.containsKey(name)) {
            return mapWithName.get(name);
        }
        return null;
    }

    public List<Person> findByName(String name) {
        return (List<Person>) doAction(Action.FIND_BY_NAME, name);
    }

    private List<Person> findByAddressInternal(String address) {
        if (mapWithAddress.containsKey(address)) {
            return mapWithAddress.get(address);
        }
        return null;
    }

    public List<Person> findByAddress(String name) {
        return (List<Person>) doAction(Action.FIND_BY_ADDRESS, name);
    }

    private List<Person> findByPhoneInternal(String phone) {
        if (mapWithPhone.containsKey(phone)) {
            return mapWithPhone.get(phone);
        }
        return null;
    }

    public List<Person> findByPhone(String name) {
        return (List<Person>) doAction(Action.FIND_BY_PHONE, name);
    }

    @SuppressWarnings("ReturnCount")
    synchronized private Object doAction(Action action, Object object) {
        switch (action) {
            case ADD -> {
                addInternal((Person) object);
                return null;
            }
            case DELETE -> {
                deleteInternal((Integer) object);
                return null;
            }
            case FIND_BY_NAME -> {
                return findByNameInternal((String) object);
            }
            case FIND_BY_PHONE -> {
                return findByPhoneInternal((String) object);
            }
            case FIND_BY_ADDRESS -> {
                return findByAddressInternal((String) object);
            }
            default -> {
            }
        }
        return null;
    }
}
