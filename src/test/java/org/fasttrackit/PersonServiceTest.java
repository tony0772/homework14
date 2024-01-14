package org.fasttrackit;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PersonServiceTest {
    @Test
    public void testAddPerson() {
        PersonService personService = new PersonService();

        Person person = new Person("Marcel", 25);

        Person addedPerson = personService.addPerson(person);

        assertNotNull(addedPerson.getId());
        assertEquals("Marcel", addedPerson.getName());
        assertEquals(25, addedPerson.getAge());

        List<Person> allPersons = personService.getAllPersons();
        assertTrue(allPersons.contains(addedPerson));
    }

    @Test
    public void testRemovePerson() {
        PersonService personService = new PersonService();

        Person person = new Person("Alina", 30);

        personService.addPerson(person);

        Person removedPerson = personService.removePerson(person.getId());

        assertEquals("Alina", removedPerson.getName());
        assertEquals(30, removedPerson.getAge());

        List<Person> allPersons = personService.getAllPersons();
        assertFalse(allPersons.contains(removedPerson));
    }
    @Test
    public void testGetPersonsOlderThan() {
        PersonService personService = new PersonService();

        Person person1 = new Person("Mirela", 25);
        Person person2 = new Person("Denis", 35);
        Person person3 = new Person("David", 40);

        personService.addPerson(person1);
        personService.addPerson(person2);
        personService.addPerson(person3);

        List<Person> olderThan30 = personService.getPersonsOlderThan(30);

        assertEquals(2, olderThan30.size());
        assertTrue(olderThan30.stream().allMatch(p -> p.getAge() > 30));
    }
    @Test
    public void testGetAllPersonNames() {
        PersonService personService = new PersonService();

        Person person1 = new Person("Jerry", 28);
        Person person2 = new Person("Frank", 32);

        personService.addPerson(person1);
        personService.addPerson(person2);

        List<String> allNames = personService.getAllPersonNames();

        assertTrue(allNames.contains("Jerry"));
        assertTrue(allNames.contains("Frank"));
    }



}
