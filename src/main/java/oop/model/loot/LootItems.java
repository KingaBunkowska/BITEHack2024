package oop.model.loot;

import oop.model.Attributes;

public enum LootItems {

    BOOK_OF_CURIOSITIES (new Attributes(0, 0, 0, 1)),
    BOOK_OF_KNOWLEDGE (new Attributes(0, 0, 0, 2)),
    BOOK_OF_ARCANE_TRUTH (new Attributes(0, 0, 0, 3)),
    BUTTER_KNIFE (new Attributes(0, 1, 0, 0)),
    BREAD_KNIFE (new Attributes(0, 2, 0, 0)),
    ACTUAL_KNIFE(new Attributes(0, 3, 0, 0)),
    SHOT_OF_VODKA(new Attributes(0, 0, 1, 0)),
    SHOT_OF_COFFEE(new Attributes(0, 0, 2, 0)),
    SHOT_OF_ADRENALINE(new Attributes(0, 0, 3, 0)),
    BAND_AID(new Attributes(0, 10, 0, 0, 0)),
    PAINKILLER(new Attributes(0, 25, 0, 0, 0)),
    BOTTLE_OF_MEDICINE(new Attributes(0, 50, 0, 0, 0));

    LootItems(Attributes attributes) {}


}
