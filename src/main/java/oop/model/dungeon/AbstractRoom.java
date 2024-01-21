package oop.model.dungeon;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRoom implements Place {

    private List<AbstractRoom> childNeighbours = new ArrayList<>();
    private List<AbstractRoom> parentNeigbours= new ArrayList<>();

    public RoomType roomType;

    public int column;

    public int height;


    public AbstractRoom(RoomType roomType, int column, int height){
        this.roomType=roomType;
        this.column=column;
        this.height =height;
    }

    public void setChildNeighbours(List<AbstractRoom> newNeighbours, int column) {

        this.childNeighbours =newNeighbours;
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
        String communication="Column "+column+" Height "+ height +" RoomType "+roomType.toString();
        for( AbstractRoom currChild : childNeighbours){
            communication=communication+" "+currChild.height;
        }
        return communication;

    }
}