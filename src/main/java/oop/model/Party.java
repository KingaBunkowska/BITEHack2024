package oop.model;

import oop.model.dungeon.AbstractRoom;
import oop.model.dungeon.Place;
import oop.model.entities.Hero;

import java.util.List;


public class Party {

    int value=0;
    private List<Hero> heroes;
    private AbstractRoom place;

    public Party(List<Hero> heroes, AbstractRoom place){
        this.heroes = heroes;
        this.place = place;
    }

    public List<Hero> getHeroes(){
        return this.heroes;
    }

    public void remove(Hero hero) {
        heroes.remove(hero);
    }

    public void clean(){
        for (Hero hero : heroes){
            if (hero.isDead()){
                remove(hero);
            }
        }
    }


    public void move(AbstractRoom place) {
        this.place = place;
    }

    public void addValue(int i) {
        value += i;
    }

    public int getValue() {
        return value;
    }
}
