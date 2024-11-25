package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    private List<Book> books;
    private List<Author> authors;

    private static LibrarySystem instance;

    private LibrarySystem() {
        books = new ArrayList<>();
        authors = new ArrayList<>();
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





    public List<Book> getBooks() {
        return books;
    }

    public List<Author> getAuthors() {
        return authors;
    }


}
