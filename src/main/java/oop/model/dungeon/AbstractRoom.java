package oop.model.dungeon;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRoom implements Place {

    private List<AbstractRoom> childNeighbours = new ArrayList<>();
    private List<AbstractRoom> parentNeigbours= new ArrayList<>();

    public RoomType roomType;

    public int column;

    public int hight;


    public AbstractRoom(RoomType roomType, int column, int hight){
        this.roomType=roomType;
        this.column=column;
        this.hight=hight;
    }

    public void setChildNeighbours(List<AbstractRoom> newNeigbours, int column) {

        this.childNeighbours =newNeigbours;
        this.column=column;
    }

    public void addChildNeighbour(AbstractRoom neighbour){
        this.childNeighbours.add(neighbour);
    }

    public void addParentNeighbour(AbstractRoom neighbour){
        this.parentNeigbours.add(neighbour);
    }

    public void startEvent(){

    }

    @Override
    public List<Place> getNeigbours() {
        return null;
    }

    public String toString(){
        String communication="Column "+column+" Hight "+hight+" RoomType "+roomType.toString();
        for( AbstractRoom currChild : childNeighbours){
            communication=communication+" "+currChild.hight;
        }
        return communication;

    }



}