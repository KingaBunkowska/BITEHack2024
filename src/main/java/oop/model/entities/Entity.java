package oop.model.entities;

import oop.model.Attributes;

public abstract class Entity {
    protected Attributes attributes;
    protected CallOf callOf;
    public Entity(){
        callOf = CallOf.getRandomValue();
    }

    public Entity(Attributes attributes){
        this.attributes = attributes;
        this.callOf = CallOf.getRandomValue();
    }

    public int getHealth() {
        return attributes.getHealth();
    }

    private void setHealth(int health){
        this.attributes = attributes.setHealth(health);
    }

    public int calculateDamage(Entity opponent){
        int damage = attributes.getStrength();
        int defence = opponent.attributes.getStrength();

        if (damage < attributes.getAgility()){
            damage = attributes.getAgility();
            defence  = opponent.attributes.getAgility();
        }

        if (damage < attributes.getIntelligence()){
            damage = attributes.getIntelligence();
            defence = opponent.attributes.getIntelligence();
        }

        if (callOf.isStrong(opponent.callOf)){
            damage *= 2;
        }
        else if (callOf.isWeak(opponent.callOf)){
            damage = (int) Math.floor(damage * 0.5);
        }

        return (int)damage - defence * Math.min((damage/defence), 1);
    }

    public void takeDamage(int damage) {
        setHealth(getHealth() - damage);
    }

    public boolean isDead(){
        return getHealth()<=0;
    }

    @Override
    public String toString(){
        return "Calling: " + callOf.toString() + "\nHealth: " + getHealth() + "/" + attributes.getMaxHealth() + "\nStats: "+ attributes.getStrength() + " " + attributes.getAgility() + " " + attributes.getIntelligence();
    }

    public Attributes getAttributes() {
        return attributes;
    }
}
