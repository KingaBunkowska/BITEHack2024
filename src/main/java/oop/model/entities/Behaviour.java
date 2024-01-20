package oop.model.entities;

import oop.model.Party;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Behaviour {

    private Comparator<Hero> comparator;
    private Random random = new Random();
    public Behaviour(Comparator<Hero> comparator){
        this.comparator = comparator;

    }

    public Hero selectTarget(Party party){
        List<Hero> suitableTargets = party.getHeroes().stream().sorted(comparator).toList();
        int rand = random.nextInt(100);
        int index = 0;
        if (rand>=95){
            index = suitableTargets.size()-1;
        }
        else if (rand >= 80){
            index = Math.min(suitableTargets.size()-2, 0);
        }
        else if (rand >= 56){
            index = Math.min(suitableTargets.size()-3, 0);
        }

        return suitableTargets.get(index);
    }

}
