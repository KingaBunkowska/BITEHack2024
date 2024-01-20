package oop.model;

import oop.model.dungeon.Dungeon;

public class Main {
    public static void main(String[] args) {
        Dungeon dungeon = new Dungeon(8);
        dungeon.representation();
    }

}