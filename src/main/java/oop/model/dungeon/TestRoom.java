package oop.model.dungeon;

import oop.model.dungeon.AbstractRoom;
import oop.model.dungeon.RoomType;

public class TestRoom extends AbstractRoom {
    public TestRoom(RoomType roomType, int column, int height) {
        super(roomType, column, height);
    }
}
