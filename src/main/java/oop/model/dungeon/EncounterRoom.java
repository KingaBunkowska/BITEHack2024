package oop.model.dungeon;

import oop.model.Party;
import oop.model.Simulation;
import oop.model.SimulationOfFight;
import oop.model.entities.Enemy;
import oop.model.loot.Loot;
import oop.model.loot.LootGenerator;

import java.util.List;

public class EncounterRoom extends AbstractRoom {

    private Enemy enemy;
    private Party party;
    public EncounterRoom(RoomType roomType, int column, int height) {
        super(roomType, column, height);
    }

    public void addEnemy(Enemy enemy){
        this.enemy = enemy;
    }


}
