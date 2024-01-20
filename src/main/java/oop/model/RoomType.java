package oop.model;

public enum RoomType {
    ENCOUNTER,
    LOOT,
    TEST,
    EMPTYROOM;

    public String toString(){

        return switch (this) {
            case ENCOUNTER -> "Encounter";
            case LOOT -> "Loot";
            case TEST -> "Test";
            case EMPTYROOM -> "Empty";
        };
    }






}
