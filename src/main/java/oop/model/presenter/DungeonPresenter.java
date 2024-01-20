package oop.model.presenter;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import oop.model.RoomRepresentation;
import oop.model.dungeon.AbstractRoom;
import oop.model.dungeon.Dungeon;

import java.util.ArrayList;
import java.util.List;

public class DungeonPresenter {
    @FXML
    private GridPane graphGrid;

    List<RoomRepresentation> roomBoxes= new ArrayList<>();

    private void clearGrid(){
        if (graphGrid.getChildren().size()!=0) {
            graphGrid.getChildren().retainAll(graphGrid.getChildren().get(0));
            graphGrid.getColumnConstraints().clear();
            graphGrid.getRowConstraints().clear();
        }
    }

    public void drawMap(){
        clearGrid();

        int columns=7;
        int lines= 3;

        for (RoomRepresentation currRoom : roomBoxes){
            graphGrid.add(currRoom,currRoom.getColumn(),currRoom.getLine());
            GridPane.setHalignment(currRoom, HPos.CENTER);
        }





    }

//    public  void initialize(){
//        dungeonBackground.setBackground(Color.white);
//        GraphicsContext gc = dungeonBackground.getGraphicsContext2D();
//        gc.setFill(Color.BLUE);
//        gc.fillRect(50,50,100,100);
//        gc.lineTo(150.5, 30.5);
//    }

    public void onGameStarted(Dungeon dungeon){

        dungeon.getAllRooms().forEach((value)->{
            roomBoxes.add(new RoomRepresentation(value));
        });


    }

}
