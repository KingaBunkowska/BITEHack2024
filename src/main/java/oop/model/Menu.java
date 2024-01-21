package oop.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import oop.model.dungeon.Dungeon;
import oop.model.presenter.DungeonPresenter;
import oop.model.presenter.MenuPresenter;

public class Menu extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("menuVisualization.fxml"));
        AnchorPane viewRoot = loader.load();
        configureStage(primaryStage,viewRoot);
        MenuPresenter menuPresenter =loader.getController();
        primaryStage.show();
    }

    private void configureStage(Stage primaryStage, Parent root) {
        var scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Menu");

    }
}
