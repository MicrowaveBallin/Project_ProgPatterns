package org.example.model;

public class Author {
    private static int counter = 1;

    private int id;
    private String name;
    private int birthYear;

    public Author(int id, String name, int birthYear) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }
}
