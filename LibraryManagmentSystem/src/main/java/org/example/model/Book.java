package org.example.model;

public class Book {
    private static int counter = 1;

    private int id;
    private String title;
    private String isbn;
    private Author author;

    public Book(int id, String title, String isbn, Author author) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.author = author;
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

    public Author getAuthor() {
        return author;
    }
}
