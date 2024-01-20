package oop.model.entities;

import oop.model.Attributes;
import oop.model.entities.Entity;

import java.util.Random;


public class Hero extends Entity {

    private final Profession profession;
    static Random random = new Random();

    public Hero(){
        super(new Attributes(
                (int)random.nextGaussian(100, 1),
                (int)random.nextGaussian(10, 1),
                (int)random.nextGaussian(10, 1),
                (int)random.nextGaussian(10, 1)
        ));

        this.profession = Profession.getRandomProfession();
        updateAttribute(profession);
    }
    public Hero(Attributes attributes) {
        super(attributes);
        this.profession = Profession.getRandomProfession();
        updateAttribute(profession);
    }

    private void updateAttribute(Profession profession){
        this.attributes = this.attributes.add(profession.getShiftOfAttributes());
    }

    public void attack(Entity opponent){
        int damage = this.calculateDamage(opponent);
        opponent.takeDamage(damage);

        System.out.println(this);
        System.out.println("Hero attacked for " + damage + "  enemy has " + opponent.getHealth());
    }

    @Override
    public String toString(){
        return "Profession: " + profession.toString() + "\n" + super.toString();
    }
}
