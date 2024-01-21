package oop.model;

import oop.model.dungeon.Place;
import oop.model.entities.Hero;

import java.util.List;


public class Party {

    int values=0;
    private List<Hero> heroes;
    private Place place;

    public Party(List<Hero> heroes, Place place){
        this.heroes = heroes;
        this.place = place;
    }

    public List<Hero> getHeroes(){
        return this.heroes;
    }

    public void remove(Hero hero) {
        heroes.remove(hero);
    }

    public Place getPlace(){
        return place;
    }

    public void move(Place place) {
        this.place = place;
        place.startEvent();
    }
}
