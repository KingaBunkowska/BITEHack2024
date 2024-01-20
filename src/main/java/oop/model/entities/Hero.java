package oop.model.entities;

import oop.model.Attributes;
import oop.model.entities.Entity;

import java.util.Random;


public class Hero extends Entity {

    private final Profession profession;
    private final CallOf callOf;
    static Random random = new Random();

    public Hero(){
        super(new Attributes(
                (int)random.nextGaussian(15, 1),
                (int)random.nextGaussian(10, 1),
                (int)random.nextGaussian(10, 1),
                (int)random.nextGaussian(10, 1)
        ));

        this.profession = Profession.getRandomProfession();
        updateAttribute(profession);
        this.callOf = CallOf.getRandomValue();
    }
    public Hero(Attributes attributes) {
        super(attributes);
        this.profession = Profession.getRandomProfession();
        updateAttribute(profession);
        this.callOf = CallOf.getRandomValue();
    }

    private void updateAttribute(Profession profession){
        this.attributes = this.attributes.add(profession.getShiftOfAttributes());
    }

}
