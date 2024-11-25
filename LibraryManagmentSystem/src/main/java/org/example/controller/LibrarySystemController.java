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

    //have seperate table inserts /////////////////////////////////////////////////////////
    syntax error to remind your dumb ass
    public void enterBooksAuthorsRecord(Book book, Author author) {
        librarySystem.addBook(book);
        librarySystem.addAuthor(author);
        book.addAuthor(author);
        author.addBook(book);
        DatabaseController.insertIntoBook(book);
        DatabaseController.insertIntoAuthor(author);
        DatabaseController.insertIntoBooksAuthors(book, author);
    }




}
