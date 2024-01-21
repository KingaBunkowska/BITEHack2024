package oop.model.presenter;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import oop.model.Game;
import oop.model.RoomRepresentation;
import oop.model.dungeon.AbstractRoom;
import oop.model.dungeon.Dungeon;

import java.util.ArrayList;
import java.util.List;

public class DungeonPresenter {
    @FXML
    private GridPane graphGrid;

    private Game game;

    List<RoomRepresentation> roomBoxes = new ArrayList<>();


    private void clearGrid() {
        if (graphGrid.getChildren().size() != 0) {
            graphGrid.getChildren().retainAll(graphGrid.getChildren().get(0));
            graphGrid.getColumnConstraints().clear();
            graphGrid.getRowConstraints().clear();
        }
    }


    public void drawMap() {
        clearGrid();

        int columns = 7;
        int lines = 3;

        for (RoomRepresentation currRoom : roomBoxes) {
            graphGrid.add(currRoom, currRoom.getColumn(), currRoom.getLine());
            GridPane.setHalignment(currRoom, HPos.CENTER);
        }


    }


    public void onGameStarted(Game game) {

        Dungeon dungeon = game.getDungeon();
        dungeon.getAllRooms().forEach((value) -> {
            roomBoxes.add(new RoomRepresentation(value, game));
        });
        for (int i = 0; i < roomBoxes.size(); i++) {
            for (int j = i; j < roomBoxes.size(); j++) {
                if (roomBoxes.get(i).getChildren().contains(roomBoxes.get(j).getAbstractRoom())) {
                    roomBoxes.get(i).children.add(roomBoxes.get(j));
                }
            }
        }
    }


}
