package oop.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import oop.model.presenter.DungeonPresenter;
import oop.model.presenter.MonsterCreatorPresenter;

public class MonsterCreator {

    public MonsterCreator(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("spawningMonsters.fxml"));
        AnchorPane viewRoot = loader.load();
        configureStage(primaryStage,viewRoot);
        MonsterCreatorPresenter monsterCreatorPresenter =loader.getController();
        primaryStage.show();
    }

    private void configureStage(Stage primaryStage, Parent root) {
        var scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MonsterPresenter");
    }


}
