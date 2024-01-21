package oop.model.loot;

import java.util.List;
import java.util.Random;

public class LootGenerator {

    private static Random random = new Random();

    public static Loot getRandomLootItem(int level, float progress){
        int number = BinomialDistribution.getRandomBinomial(level, progress);
        int itemLevel = 1;

        if (number>=20){
            itemLevel = 3;
        }
        else if(number>=10){
            itemLevel = 2;
        }

        List<LootItems> suitableItems = LootItems.getItemsLeveled(itemLevel);
        return new Loot((itemLevel*10)*(itemLevel*10),suitableItems.get(random.nextInt(0, suitableItems.size()-1)));
    }

}
