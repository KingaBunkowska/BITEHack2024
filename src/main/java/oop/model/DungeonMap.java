package oop.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import oop.model.dungeon.Dungeon;
import oop.model.presenter.DungeonPresenter;

public class DungeonMap extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("dungeonVisualization.fxml"));
        BorderPane viewRoot = loader.load();
        configureStage(primaryStage,viewRoot);
        DungeonPresenter dungeonPresenter =loader.getController();
        primaryStage.show();
        Dungeon dungeon = new Dungeon(8);
        dungeonPresenter.onGameStarted(dungeon);
        dungeonPresenter.drawMap();
    }

    private void configureStage(Stage primaryStage, BorderPane viewRoot) {
        var scene = new Scene(viewRoot);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dungeon");
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty());
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty());
    }
}
