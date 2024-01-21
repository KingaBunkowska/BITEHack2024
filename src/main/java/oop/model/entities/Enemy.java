package oop.model.entities;

import oop.model.Attributes;
import oop.model.Party;

import java.util.Comparator;

public class Enemy extends Entity{
    private Kind kind;

    public Enemy(Attributes attributes) {
        super(attributes);
        kind = Kind.getRandomKind();
    }

    public Behaviour getBehaviour() {
        return kind.getBehaviour();
    }

    public void attack(Party party){
        Hero target = getBehaviour().selectTarget(party);
        int damage = this.calculateDamage(target);
        target.takeDamage(damage);

        System.out.println(this);
        System.out.println("Enemy attacked for " + damage + "  Hero left with " + target.getHealth());
    }

    @Override
    public String toString(){
        return "Kind: " + kind.toString() + "\n" + super.toString();
    }

}
