package oop.model.entities;

import oop.model.Attributes;

import java.util.Random;

public enum Profession {

    VIGILANTE(new Attributes(0, 0, 10, 0, 0)),
    SMUGGLER(new Attributes(0, 0, 0, 10, 0)),
    ARCHAEOLOGIST(new Attributes(0, 0, 0, 0, 10));

    Profession(Attributes shiftOfAttributes) {
        this.shiftOfAttributes = shiftOfAttributes;
    }

    private final Attributes shiftOfAttributes;
    private static final Random random = new Random();

    public Attributes getShiftOfAttributes() {
        return shiftOfAttributes;
    }

    public static Profession getRandomProfession(){
        return Profession.values()[random.nextInt(0,Profession.values().length)];
    }
}
