package org.example.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Author {
    private static int counter = 1;

    private int id;
    private String name;
    private int birthYear;
    private Set<Book> books;

    public Author(String name, int birthYear) {
        this.id = counter++;
        this.name = name;
        this.birthYear = birthYear;
        this.books = new HashSet<>();
    }

    public Author(int id, String name, int birthYear) {
        counter++;
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.books = new HashSet<>();
    }

    public void addBook(Book book) {
        books.add(book);
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

    public Set<Book> getBooks() {
        return books;
    }
}
