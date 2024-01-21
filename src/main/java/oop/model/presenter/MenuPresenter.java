package oop.model.presenter;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import oop.model.DungeonMap;
import oop.model.Game;
import oop.model.MonsterCreator;
import oop.model.SimulationOfFight;

public class MenuPresenter {

    @FXML
    public Button startButton;

    public void handleStartButtonAction(ActionEvent actionEvent) throws Exception {
        Stage stage = new Stage();
//        DungeonMap simulation = new DungeonMap(stage);
        MonsterCreator monsterCreator= new MonsterCreator(stage);

    }


}
