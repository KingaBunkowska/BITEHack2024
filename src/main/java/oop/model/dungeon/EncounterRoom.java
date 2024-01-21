package oop.model.dungeon;

import oop.model.Party;
import oop.model.entities.Enemy;


public class EncounterRoom extends AbstractRoom {

    private Enemy enemy;
    private Party party;
    public EncounterRoom(RoomType roomType, int column, int height) {
        super(roomType, column, height);
    }

    public void addEnemy(Enemy enemy){
        this.enemy = enemy;
    }

    public Enemy getEnemy(){
        return enemy;
    }


}
