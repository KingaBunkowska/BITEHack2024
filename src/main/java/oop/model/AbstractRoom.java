package oop.model;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRoom implements Place {

    private List<AbstractRoom> childNeigbours= new ArrayList<>();
    private List<AbstractRoom> parentNeigbours= new ArrayList<>();

    protected RoomType roomType;

    protected int column;

    public int hight;


    public AbstractRoom(RoomType roomType, int column, int hight){
        this.roomType=roomType;
        this.column=column;
        this.hight=hight;
    }

    public void setChildNeigbours(List<AbstractRoom> newNeigbours, int column) {

        this.childNeigbours=newNeigbours;
        this.column=column;
    }

    public void addChildNeigbour(AbstractRoom neighbour){
        this.childNeigbours.add(neighbour);
    }

    public void addParentNeigbour(AbstractRoom neighbour){
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
        for( AbstractRoom currChild : childNeigbours){
            communication=communication+" "+currChild.hight;
        }
        return communication;

    }



}