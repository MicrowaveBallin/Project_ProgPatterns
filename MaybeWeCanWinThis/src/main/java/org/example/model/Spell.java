package org.example.model;

public class Spell {

    private static int counter = 1;
    private int id;
    private String name;

    public Spell(String name) {
        this.id = counter++;
        this.name = name;
    }




    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
