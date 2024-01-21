package oop.model.dungeon;

import oop.model.Party;
import oop.model.dungeon.AbstractRoom;
import oop.model.dungeon.RoomType;
import oop.model.entities.Hero;

import java.util.Random;

public class TestRoom extends AbstractRoom {
    private final Random random = new Random();
    private final int testAttribute;
    public TestRoom(RoomType roomType, int column, int height) {
        super(roomType, column, height);
        testAttribute = random.nextInt(0,3);
    }

    public void startTest(Party party){

        for (Hero hero :party.getHeroes()){
            int result = random.nextInt(0, 30);
            if(testAttribute==0 && result > hero.getAttributes().getStrength()){
                hero.takeDamage(Math.max(result - hero.getAttributes().getStrength(),0));
            }
            else if(testAttribute==1 && result > hero.getAttributes().getAgility()){
                hero.takeDamage(Math.max(result - hero.getAttributes().getAgility(),0));
            }
            else if(testAttribute==2 && random.nextInt(0, 30)>hero.getAttributes().getIntelligence()){
                hero.takeDamage(Math.max(result - hero.getAttributes().getIntelligence(),0));
            }
        }

    }

}
