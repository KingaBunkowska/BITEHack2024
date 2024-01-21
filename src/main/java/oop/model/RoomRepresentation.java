package oop.model;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import oop.model.dungeon.AbstractRoom;

import javafx.scene.shape.Rectangle;
import oop.model.dungeon.RoomType;

public class RoomRepresentation extends VBox {

    private final AbstractRoom abstractRoom;

    private Rectangle rectangle;

    private final int column;
    private final int line;


    public RoomRepresentation(AbstractRoom abstractRoom){
        this.abstractRoom=abstractRoom;
        this.column=abstractRoom.column;
        colorRectangle();
        this.line=abstractRoom.hight;
        this.getChildren().addAll(this.rectangle);
        this.setAlignment(Pos.CENTER);
    }

    public void colorRectangle(){
        switch (abstractRoom.roomType) {
            case ENCOUNTER ->this.rectangle= new Rectangle(50, 50, Color.rgb(200, 50, 0));
            case LOOT ->this.rectangle= new Rectangle(50, 50, Color.rgb(255, 215, 0));
            case TEST ->this.rectangle= new Rectangle(50, 50, Color.rgb(0, 0, 255));
            case EMPTYROOM ->this.rectangle= new Rectangle(50, 50, Color.rgb(0, 255, 0));

        }
    }

    public int getColumn() {
        return column;
    }

    public int getLine() {
        return line;
    }
}
