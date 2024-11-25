package org.example.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Book {
    private static int counter = 1;

    private int id;
    private String title;
    private String isbn;
    private int publishYear;
    private Set<Author> authors;

    public Book(String title, String isbn, int publishYear) {
        this.id = counter++;
        this.title = title;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.authors = new HashSet<>();
    }

    public Book(int id, String title, String isbn, int publishYear) {
        counter++;
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.authors = new HashSet<>();
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public Set<Author> getAuthors() {
        return authors;
    }
}
