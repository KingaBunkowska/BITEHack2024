package oop.model;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

public class Attributes {

    private final int maxHealth;
    private final int health;
    private final int strength;
    private final int agility;
    private final int intelligence;

    public Attributes(int maxHealth, int health, int strength, int agility, int intelligence){
        this.maxHealth = maxHealth;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public Attributes(int maxHealth, int strength, int agility, int intelligence){
        this(maxHealth, maxHealth, strength, agility, intelligence);
    }

    public Attributes add(Attributes attributes){
        return new Attributes(
                this.maxHealth + attributes.getMaxHealth(),
                this.health + attributes.getHealth(),
                this.strength + attributes.getStrength(),
                this.agility + attributes.getAgility(),
                this.intelligence + attributes.getIntelligence()
                );
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence(){
        return intelligence;
    }

    public int getMaxHealth(){
        return maxHealth;
    }

    public Attributes setHealth(int health){
        return new Attributes(maxHealth, health, strength, agility, intelligence);
    }
}
