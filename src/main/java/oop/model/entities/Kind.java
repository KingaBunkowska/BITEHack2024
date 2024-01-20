package oop.model.entities;

import java.util.Comparator;
import java.util.Random;

public enum Kind {
    MANYLEGS (new Behaviour (Comparator.comparing(hero -> hero.attributes.getAgility()))),
    SCARY_CAT ( new Behaviour(Comparator.comparing(hero -> hero.attributes.getIntelligence()))),
    LIZARD (new Behaviour(Comparator.comparing(hero -> hero.attributes.getStrength())));


    private Behaviour behaviour;
    private static Random random = new Random();
    Kind(Behaviour behaviour){
        this.behaviour = behaviour;
    };

    public static Kind getRandomKind() {
        return Kind.values()[random.nextInt(0,Kind.values().length)];
    }


    public Behaviour getBehaviour(){
        return this.behaviour;
    }
}
