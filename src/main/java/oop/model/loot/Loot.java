package oop.model.loot;

import oop.model.Attributes;

public class Loot {
    private final int value;
    private final LootItems typeOfItem;

    public Loot(int value, LootItems typeOfItem){
        this.value = value;
        this.typeOfItem = typeOfItem;
    }

    public LootItems getTypeOfItem() {
        return typeOfItem;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString(){
        return "Loot: "+this.typeOfItem + "\t Value: " + value;
    }
}
