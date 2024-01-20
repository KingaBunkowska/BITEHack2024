package oop.model.entities;

import java.util.Random;

public enum CallOf{
    BLOOD,
    WEALTH,
    MYSTERY;

    private static final Random random = new Random();
    public boolean isWeak(CallOf callOf){
        return CallOf.values()[this.ordinal()].next().equals(callOf);
    }

    public boolean isStrong(CallOf callOf){
        return this.previous().equals(callOf);
    }

    public CallOf next(){
        return CallOf.values()[(this.ordinal()+1)%values().length];
    }

    public static CallOf getRandomValue(){
        return CallOf.values()[random.nextInt(0,CallOf.values().length)];
    }

    public CallOf previous(){
        return CallOf.values()[(this.ordinal()-1)%values().length];
    }
}
