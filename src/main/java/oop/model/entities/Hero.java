package oop.model.entities;

import oop.model.Attributes;
import oop.model.HeroListener;
import oop.model.entities.Entity;
import oop.model.loot.Loot;

import java.util.Optional;
import java.util.Random;


public class Hero extends Entity {

    private final Profession profession;
    static Random random = new Random();
    Optional<HeroListener> listener = Optional.empty();

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

    @Override
    public void takeDamage(int value){
        super.takeDamage(value);
        listener.ifPresent(listener1 -> listener1.heroChanged(this));
    }

    private void updateAttribute(Profession profession){
        this.attributes = this.attributes.add(profession.getShiftOfAttributes());
        listener.ifPresent(listener->listener.heroChanged(this));
    }

    public void attack(Entity opponent){
        int damage = this.calculateDamage(opponent);
        opponent.takeDamage(damage);

        System.out.println(this);
        System.out.println("\nHero attacked for " + damage + "  enemy has " + opponent.getHealth());
    }

    public int useItemReturnValue(Loot loot){
        this.attributes = this.attributes.add(loot.getTypeOfItem().getAttributes());

        listener.ifPresent(listener->listener.heroChanged(this));
        return loot.getValue();
    }

    @Override
    public String toString(){
        return "Profession: " + profession.toString() + "\n" + super.toString();
    }

    public void addListener(HeroListener listener){
        this.listener = Optional.of(listener);
        listener.heroChanged(this);
    }
}
