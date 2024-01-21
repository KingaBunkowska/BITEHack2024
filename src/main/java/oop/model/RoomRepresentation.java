package oop.model;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import oop.model.dungeon.AbstractRoom;
import javafx.scene.shape.StrokeType;

import javafx.scene.shape.Rectangle;
import oop.model.dungeon.RoomType;

import java.util.ArrayList;
import java.util.List;

public class RoomRepresentation extends VBox {

    public final AbstractRoom abstractRoom;

    private Rectangle rectangle;

    private final int column;
    private final int line;

    public List<RoomRepresentation> children= new ArrayList<>();


    public RoomRepresentation(AbstractRoom abstractRoom){
        this.abstractRoom=abstractRoom;
        this.column=abstractRoom.column;
        colorRectangle();
        this.line=abstractRoom.hight;
        this.getChildren().addAll(this.rectangle);
        this.setAlignment(Pos.CENTER);
        this.children=children;
    }

    public void colorRectangle(){
        switch (abstractRoom.roomType) {
            case ENCOUNTER ->this.rectangle= new Rectangle(50, 50, Color.rgb(200, 50, 0));
            case LOOT ->this.rectangle= new Rectangle(50, 50, Color.rgb(255, 215, 0));
            case TEST ->this.rectangle= new Rectangle(50, 50, Color.rgb(0, 0, 255));
            case EMPTYROOM ->this.rectangle= new Rectangle(50, 50, Color.rgb(0, 255, 0));
        }

        rectangle.setOnMouseClicked(event -> {
            this.mosueClicked();
        });

        rectangle.setOnMouseEntered(event -> {
            this.mouseEnter();
        });

        rectangle.setOnMouseExited(event -> {
            this.mouseByeBye();
        });


    }

    public void mouseEnter(){
        System.out.println("Myszka najechała na pole!");
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
        System.out.println("Myszka opuściła pole!");
    }


    public void mosueClicked(){
        System.out.println("Rectangle Clicked!");
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
