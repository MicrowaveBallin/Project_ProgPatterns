package org.example.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LibrarySystem {
    private Set<Book> books;
    private Set<Author> authors;

    private static LibrarySystem instance;

    private LibrarySystem() {
        books = new HashSet<>();
        authors = new HashSet<>();
    }

    public static LibrarySystem getInstance() {
        if (instance == null) {
            synchronized (LibrarySystem.class) {
                if (instance == null) {
                    instance = new LibrarySystem();
                }
            }
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }





    public Set<Book> getBooks() {
        return books;
    }

    public Set<Author> getAuthors() {
        return authors;
    }


}
