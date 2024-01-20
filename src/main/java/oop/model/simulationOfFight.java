package oop.model;

import oop.model.entities.Enemy;
import oop.model.entities.Hero;

public class simulationOfFight {
    private Enemy enemy;
    private Party party;

    public simulationOfFight(Party party, Enemy enemy){
        this.party = party;
        this.enemy = enemy;
    }

    // if true party wins
    public boolean simulateFight(){
        while (!enemy.isDead() && !party.getHeroes().isEmpty()){
            simulateTurn();
        }
        return !party.getHeroes().isEmpty();
    }
    private void simulateTurn(){
        enemy.attack(party);
        for (Hero hero : party.getHeroes()){
            hero.attack(enemy);
        }
        cleanDead();
    }

    private void cleanDead(){
        for (Hero hero : party.getHeroes()){
            if (hero.isDead()){
                party.remove(hero);
            }
        }
    }

}
