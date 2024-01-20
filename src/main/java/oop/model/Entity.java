package oop.model;

public abstract class Entity {
    private int health;
    private int maxHealth;
    private int intelligence;
    private int strength;
    private int agility;
    private int toughness;

    public Entity(int maxHealth, int health, int intelligence, int strength, int agility, int toughness){
        this.maxHealth = maxHealth;
        this.health = health;
        this.intelligence = intelligence;
        this.strength = strength;
        this.agility = agility;
        this.toughness = toughness;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }
}
