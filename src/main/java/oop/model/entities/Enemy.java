package oop.model.entities;

import oop.model.Attributes;
import oop.model.Party;

import java.util.Comparator;

public class Enemy extends Entity{

    private Comparator<Hero> behaviour;
    private Kind kind;

    public Enemy(Attributes attributes) {
        super(attributes);
    }

    public Comparator<Hero> getBehaviour() {
        return behaviour;
    }

    public void attack(Party party){
        Hero target = party.getTarget(getBehaviour());
        int damage = this.calculateDamage(target);
        target.takeDamage(damage);
    }
}
