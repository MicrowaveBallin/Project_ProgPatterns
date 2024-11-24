package org.example.model;

public class Wizard {

    private static int counter = 1;
    private int id;
    private String name;
    private Spell spell;

    public Wizard(String name, Spell spell) {
        this.id = counter++;
        this.name = name;
        this.spell = spell;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Spell getSpell() {
        return spell;
    }
}
