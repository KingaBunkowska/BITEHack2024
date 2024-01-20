package oop.model.entities;

import oop.model.Attributes;

public abstract class Entity {
    protected Attributes attributes;

    public Entity(Attributes attributes){
        this.attributes = attributes;
    }

    public int getHealth() {
        return attributes.getHealth();
    }

    public void setHealth(int health){
        this.attributes = attributes.setHealth(health);
    }
}
