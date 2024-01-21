package oop.model.presenter;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import oop.model.Game;
import oop.model.HeroListener;
import oop.model.RoomRepresentation;
import oop.model.dungeon.AbstractRoom;
import oop.model.dungeon.Dungeon;
import oop.model.entities.Hero;

import javax.sound.sampled.Line;
import java.util.*;

public class DungeonPresenter implements HeroListener {
    public Label money;
    public Label str1;
    public Label int1;
    public Label ag1;
    public Label str2;
    public Label int2;
    public Label ag2;
    public Label str3;
    public Label int3;
    public Label ag3;
    public Label str4;
    public Label int4;
    public Label ag4;
    public Label hp1;
    public Label hp2;
    public Label hp3;
    public Label hp4;
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

        List<Hero> heroes = game.getParty().getHeroes();

            Hero hero = heroes.get(0);
            List<Label> stats = new LinkedList<>();
            stats.add(hp1);
            stats.add(str1);
            stats.add(ag1);
            stats.add(int1);

            heroToList.put(hero, stats);
            hero.addListener(this);

            List<Label> stats2 = new LinkedList<>();
            hero = heroes.get(1);
            stats2.add(hp2);
            stats2.add(str2);
            stats2.add(ag2);
            stats2.add(int2);

            heroToList.put(hero, stats2);
            hero.addListener(this);

        List<Label> stats3 = new LinkedList<>();
            hero = heroes.get(2);
            stats3.add(hp3);
            stats3.add(str3);
            stats3.add(ag3);
            stats3.add(int3);

            heroToList.put(hero, stats3);
            hero.addListener(this);

        List<Label> stats4 = new LinkedList<>();
        hero = heroes.get(3);
        stats4.add(hp4);
        stats4.add(str4);
        stats4.add(ag4);
        stats4.add(int4);

        heroToList.put(hero, stats4);
        hero.addListener(this);


        }
    Map<Hero, List<Label>> heroToList = new HashMap<>();

    @Override
    public void heroChanged(Hero hero) {
        List<Label> label = heroToList.get(hero);
        label.get(0).setText(hero.getHealth()+"");
        label.get(1).setText(hero.getAttributes().getStrength()+"");
        label.get(2).setText(hero.getAttributes().getAgility()+"");
        label.get(3).setText(hero.getAttributes().getIntelligence()+"");
    }
}
