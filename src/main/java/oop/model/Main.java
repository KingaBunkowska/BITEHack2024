package oop.model;

import oop.model.dungeon.Dungeon;
import oop.model.dungeon.EmptyRoom;
import oop.model.dungeon.RoomType;
import oop.model.entities.CallOf;
import oop.model.entities.Enemy;
import oop.model.entities.Hero;
import oop.model.entities.Kind;

import java.util.LinkedList;
import java.util.List;

import static oop.model.dungeon.RoomType.EMPTYROOM;

public class Main {
    public static void main(String[] args) {
//        Dungeon dungeon = new Dungeon(8);
//        dungeon.representation();

        // test fight

        Enemy enemy = new Enemy(15, Kind.MANYLEGS, CallOf.BLOOD, 60);
        Hero hero1 = new Hero();
        Hero hero2 = new Hero();

        List<Hero> heroes = new LinkedList<>();
        heroes.add(hero1);
        heroes.add(hero2);

        Party party = new Party(heroes, new EmptyRoom(EMPTYROOM, 4, 3));

        SimulationOfFight simulation = new SimulationOfFight(party, enemy);
        simulation.simulateFight();
    }



}