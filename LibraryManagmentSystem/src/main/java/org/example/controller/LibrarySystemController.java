package org.example.controller;

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




}
