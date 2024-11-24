package org.example.model;

import org.example.controller.ShadowMoneyGangController;

import java.util.ArrayList;
import java.util.List;

public class ShadowMoneyGang {
    private List<Wizard> wizards;
    private List<Spell> spells;

    private static ShadowMoneyGang instance;

    private ShadowMoneyGang() {
        //this.wizards = DatabaseController.getAllWizards();
        //this.spells = DatabaseController.getAllSpells();
    }

    public static ShadowMoneyGang getInstance() {
        if (instance == null) {
            synchronized (ShadowMoneyGang.class) {
                if (instance == null) {
                    instance = new ShadowMoneyGang();
                }
            }
        }
        return instance;
    }

}
