package oop.model;

import oop.model.dungeon.Place;
import oop.model.entities.Hero;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Party {
    private List<Hero> heroes;
    private Place place;

    public Party(List<Hero> heroes, Place place){
        this.heroes = heroes;
        this.place = place;
    }

    public List<Hero> getHeroes(){
        return this.heroes;
    }

    public Hero getTarget(Comparator<Hero> comparator){
        return Collections.max(heroes, comparator);
    }

    public void remove(Hero hero) {
        heroes.remove(hero);
    }

    public Place getPlace(){
        return place;
    }
}
