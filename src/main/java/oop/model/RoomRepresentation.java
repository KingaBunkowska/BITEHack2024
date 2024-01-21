package oop.model;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import oop.model.dungeon.AbstractRoom;

import javafx.scene.shape.Rectangle;

public class RoomRepresentation extends VBox {

    private final AbstractRoom abstractRoom;

    private final Rectangle rectangle;

    private final int column;
    private final int line;


    public RoomRepresentation(AbstractRoom abstractRoom){
        this.abstractRoom=abstractRoom;
        this.rectangle= new Rectangle(20, 20, Color.rgb(200,50,0));
        this.column=abstractRoom.column;
        this.line=abstractRoom.height;
        this.getChildren().addAll(this.rectangle);
        this.setAlignment(Pos.CENTER);
    }

    public int getColumn() {
        return column;
    }

    public int getLine() {
        return line;
    }
}
