package org.example.controller;

import org.example.model.Author;
import org.example.model.Book;
import org.example.model.LibrarySystem;

import java.util.List;

public class LibrarySystemController {
    private LibrarySystem librarySystem;

    public LibrarySystemController() {
        this.librarySystem = LibrarySystem.getInstance();
        initTables();
    }

    private void initTables() {
        DatabaseController.createAllTables();
    }

    public void enterBookRecord(Book book) {
        librarySystem.addBook(book);
        DatabaseController.insertIntoBook(book);
    }

    public void enterAuthorRecord(Author author) {
        librarySystem.addAuthor(author);
        DatabaseController.insertIntoAuthor(author);
    }

    //have seperate table inserts??????????????????????????????????????????????????????????????????????????????????
    public void enterBooksAuthorsRecord(Book book, Author author) {
        book.addAuthor(author);
        author.addBook(book);
        DatabaseController.insertIntoBooksAuthors(book, author);
    }






}
