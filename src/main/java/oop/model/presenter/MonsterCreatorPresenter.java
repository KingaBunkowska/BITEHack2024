package oop.model.presenter;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.stage.Stage;
import oop.model.DungeonMap;
import oop.model.Game;
import oop.model.entities.CallOf;
import oop.model.entities.Entity;
import oop.model.entities.Kind;

public class MonsterCreatorPresenter {



    public Game game=new Game();
    public Spinner powerLevel;
    public Spinner health;
    public ComboBox kind;
    public ComboBox call;

    public void handleAddEnemyAction(ActionEvent actionEvent) throws Exception {

        if(game.areAllEnemiesSet()){
            game.populateDungeons();
            Stage stage = new Stage();
            DungeonMap simulation=new DungeonMap(stage, game);

        }
        else{
            int power= (int) powerLevel.getValue();
            int currHealth= (int) health.getValue();
            Kind currKind;
            if (kind.getValue()=="MANLEGS"){
                currKind=Kind.MANYLEGS;
            }
            else if(kind.getValue()=="SCARYCAT"){
                currKind=Kind.SCARY_CAT;
            }
            else{
                currKind=Kind.LIZARD;
            }

            CallOf currCall;
            if (call.getValue()=="BLOOD"){
                currCall=CallOf.BLOOD;
            }
            else if(call.getValue()=="WEALTH"){
                currCall=CallOf.WEALTH;
            }
            else{
                currCall=CallOf.MYSTERY;
            }

            game.interactiveMakeEnemy(power,currKind,currCall,currHealth);

        }


    }
}
