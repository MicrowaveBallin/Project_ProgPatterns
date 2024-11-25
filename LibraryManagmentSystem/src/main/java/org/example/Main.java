package org.example;

import org.example.controller.DatabaseController;
import org.example.controller.TestDBController;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //create tables
        DatabaseController.createAllTables();

        //insert into books
        //DatabaseController();



    }
}