package oop.model.entities;

import oop.model.Attributes;

import java.util.Comparator;
import java.util.Random;

public enum Kind {
    MANYLEGS (new Attributes(0, 0, 5, 5), new Behaviour (Comparator.comparing(hero -> hero.attributes.getAgility()))),
    SCARY_CAT (new Attributes(0, 2, 4, 2) ,new Behaviour(Comparator.comparing(hero -> hero.attributes.getIntelligence()))),
    LIZARD (new Attributes(0, 6, 2, 3) ,new Behaviour(Comparator.comparing(hero -> hero.attributes.getStrength())));


    private Behaviour behaviour;
    private Attributes shiftOfAttributes;
    private static Random random = new Random();
    Kind(Attributes attributes, Behaviour behaviour){
        this.behaviour = behaviour;
        this.shiftOfAttributes = attributes;
    };

    public static Kind getRandomKind() {
        return Kind.values()[random.nextInt(0,Kind.values().length)];
    }


    public Behaviour getBehaviour(){
        return this.behaviour;
    }

    public Attributes getShiftOfAttributes() {
        return shiftOfAttributes;
    }
}
