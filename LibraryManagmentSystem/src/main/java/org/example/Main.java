package org.example;

import org.example.controller.DatabaseController;
import org.example.controller.LibrarySystemController;
import org.example.controller.TestDBController;
import org.example.model.Author;
import org.example.model.Book;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //create tables
        LibrarySystemController controller = new LibrarySystemController();

        //create objects
        Book b1 = new Book("You are worth it!","30421103",2019);
        Book b2 = new Book("Give up","4042763",2020);
        Author a1 = new Author("Jokry Treeeater",1957);
        Author a2 = new Author("Dink",1998);

        //insert a record
        controller.enterBookRecord(b1);
        controller.enterBookRecord(b2);
        controller.enterAuthorRecord(a1);
        controller.enterAuthorRecord(a2);
        controller.enterBooksAuthorsRecord(b1,a1);
        controller.enterBooksAuthorsRecord(b1,a2);
        controller.enterBooksAuthorsRecord(b2,a2);

        //DatabaseController.insertIntoBook(b1);
        //DatabaseController.insertIntoAuthor(a1);
        //DatabaseController.insertIntoBooksAuthors(b1,a1);




    }
}