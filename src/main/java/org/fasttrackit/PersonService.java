package org.fasttrackit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonService {
    private Map<Integer, Person> persons = new HashMap<>();
    private int nextId = 1;

    public Person addPerson(Person person) {
        int id = nextId++;
        person.setId(id);
        persons.put(id, person);
        return person;
    }

    public Person removePerson(int id) {
        if (!persons.containsKey(id)) {
            throw new IllegalArgumentException("Person with id " + id + " not found");
        }
        return persons.remove(id);
    }

    public List<Person> getAllPersons() {
        return new ArrayList<>(persons.values());
    }

    public List<Person> getPersonsOlderThan(int age) {
        if (age <= 0 || age >= 120) {
            throw new IllegalArgumentException("Invalid age");
        }

        List<Person> result = new ArrayList<>();
        for (Person person : persons.values()) {
            if (person.getAge() > age) {
                result.add(person);
            }
        }
        return result;
    }

    public List<String> getAllPersonNames() {
        List<String> names = new ArrayList<>();
        for (Person person : persons.values()) {
            names.add(person.getName());
        }
        return names;
    }

    public Person getPerson(String name) {
        for (Person person : persons.values()) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public Person getPersonById(int id) {
        return persons.get(id);
    }
}
