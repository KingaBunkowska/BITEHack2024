package oop.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import oop.model.dungeon.Dungeon;
import oop.model.presenter.DungeonPresenter;


public class DungeonMap{
    private Game game;

    public DungeonMap(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("dungeonVisualization.fxml"));
        AnchorPane viewRoot = loader.load();
        configureStage(primaryStage,viewRoot);
        DungeonPresenter dungeonPresenter =loader.getController();
        primaryStage.show();
        game = new Game();
        dungeonPresenter.onGameStarted(game);
        dungeonPresenter.drawMap();
    }

    private void configureStage(Stage primaryStage, Parent root) {
        var scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dungeon");
    }
}
