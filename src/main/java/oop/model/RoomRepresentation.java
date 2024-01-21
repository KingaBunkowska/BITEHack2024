package oop.model;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import oop.model.dungeon.AbstractRoom;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class RoomRepresentation extends VBox {

    public final AbstractRoom abstractRoom;

    private Rectangle rectangle;

    private final int column;
    private final int line;

    public List<RoomRepresentation> children= new ArrayList<>();
    private final Game game;

    public RoomRepresentation(AbstractRoom abstractRoom, Game game){
        this.abstractRoom=abstractRoom;
        this.column=abstractRoom.column;
        colorRectangle();

        this.line=abstractRoom.height;
        this.getChildren().addAll(this.rectangle);
        this.setAlignment(Pos.CENTER);
        this.children=children;
        this.game = game;
    }

    public void colorRectangle(){
        switch (abstractRoom.roomType) {
            case ENCOUNTER ->this.rectangle= new Rectangle(50, 50, Color.rgb(200, 50, 0));
            case LOOT ->this.rectangle= new Rectangle(50, 50, Color.rgb(255, 215, 0));
            case TEST ->this.rectangle= new Rectangle(50, 50, Color.rgb(0, 0, 255));
            case EMPTYROOM ->this.rectangle= new Rectangle(50, 50, Color.rgb(0, 255, 0));
        }

        rectangle.setOnMouseClicked(event -> {
            this.mouseClicked();
        });

        rectangle.setOnMouseEntered(event -> {
            this.mouseEnter();
        });

        rectangle.setOnMouseExited(event -> {
            this.mouseByeBye();
        });


    }

    public void mouseEnter(){
        updatEdges();
    }

    public void updatEdges(){
        rectangle.setStrokeWidth(2);
        rectangle.setStroke(Color.BLACK);
        for(RoomRepresentation child: children){
            child.updatEdges();
        }
    }

    public void mouseByeBye(){
        rectangle.setStroke(null);
        for(RoomRepresentation child: children){
            child.mouseByeBye();
        }
    }


    public void mouseClicked(){
        game.simulateTurn(abstractRoom);
    }



    public int getColumn() {
        return column;
    }

    public int getLine() {
        return line;
    }

    public String toString(){
        return abstractRoom.toString();
    }

    public AbstractRoom getAbstractRoom() {
        return abstractRoom;
    }
}
