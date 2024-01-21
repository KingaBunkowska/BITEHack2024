package oop.model.loot;

import oop.model.Attributes;

import java.util.Arrays;
import java.util.List;

public enum LootItems {

    BOOK_OF_CURIOSITIES (1, new Attributes(0, 0, 0, 1)),
    BOOK_OF_KNOWLEDGE (2, new Attributes(0, 0, 0, 2)),
    BOOK_OF_ARCANE_TRUTH (3, new Attributes(0, 0, 0, 3)),
    BUTTER_KNIFE (1, new Attributes(0, 1, 0, 0)),
    BREAD_KNIFE (2, new Attributes(0, 2, 0, 0)),
    ACTUAL_KNIFE(3, new Attributes(0, 3, 0, 0)),
    SHOT_OF_VODKA(1, new Attributes(0, 0, 1, 0)),
    SHOT_OF_COFFEE(2, new Attributes(0, 0, 2, 0)),
    SHOT_OF_ADRENALINE(3, new Attributes(0, 0, 3, 0)),
    BAND_AID(1, new Attributes(0, 10, 0, 0, 0)),
    PAINKILLER(2, new Attributes(0, 25, 0, 0, 0)),
    BOTTLE_OF_MEDICINE(3, new Attributes(0, 50, 0, 0, 0));

    private int level;
    private final Attributes attributes;
    LootItems(int level, Attributes attributes) {
        this.level = level;
        this.attributes = attributes;
    }

    public static List<LootItems> getItemsLeveled(int level){
        return Arrays.stream(values()).filter(lootItems -> (lootItems.level == level)).toList();
    }

    public Attributes getAttributes() {
        return attributes;
    }

}
