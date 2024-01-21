package oop.model.entities;

import oop.model.Attributes;
import oop.model.Party;

import java.util.Comparator;

import static oop.model.entities.Hero.random;

public class Enemy extends Entity{
    private final Kind kind;
    private int level;



    public Enemy(Attributes attributes) {
        super(attributes);
        kind = Kind.getRandomKind();
    }

    public Enemy(int power, Kind kind, CallOf callOf, int maxHealth){
        super();
        Attributes att = new Attributes(
                (int)Math.max(random.nextGaussian(maxHealth, 10),1),
                (int)Math.max(random.nextGaussian(power, 4), 1),
                (int)Math.max(random.nextGaussian(power, 4), 1),
                (int)Math.max(random.nextGaussian(power, 4), 1)
        );
        this.kind = kind;
        this.callOf = callOf;

        this.attributes = att.add(kind.getShiftOfAttributes());
        this.level = power + 3;
    }

    public Behaviour getBehaviour() {
        return kind.getBehaviour();
    }

    public void attack(Party party){
        Hero target = getBehaviour().selectTarget(party);
        int damage = this.calculateDamage(target);
        target.takeDamage(damage);

        System.out.println(this);
        System.out.println("\nEnemy attacked for " + damage + "  Hero left with " + target.getHealth());
    }

    @Override
    public String toString(){
        return "Kind: " + kind.toString() + "\n" + super.toString();
    }

    public int getLevel(){
        return level;
    }

}
