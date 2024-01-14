package org.fasttrackit;

public class Person {
    private int id;
    private String name;
    private int age;

    public Person(String name, int age) {
        if (age <= 0 || age >= 120 || name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid age or name");
        }

        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }
}
