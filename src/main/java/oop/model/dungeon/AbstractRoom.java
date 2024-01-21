package oop.model.dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractRoom that = (AbstractRoom) o;
        return column == that.column && hight == that.hight && Objects.equals(childNeighbours, that.childNeighbours) && Objects.equals(parentNeigbours, that.parentNeigbours) && roomType == that.roomType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(childNeighbours, parentNeigbours, roomType, column, hight);
    }
}