package oop.model.dungeon;

import oop.model.*;

import java.util.*;


public class Dungeon {

    private int size;

    private List<AbstractRoom> allRooms=new ArrayList<>();


    public Dungeon(int size){
        this.size=size;

        EmptyRoom startRoom =new EmptyRoom(RoomType.EMPTYROOM, 0,0);
        allRooms.add(startRoom);
        List<AbstractRoom> predRooms = new ArrayList<>();
        predRooms.add(startRoom);


        for (int i=1;i<size;i++){
            List<AbstractRoom> currRooms = new ArrayList<>();
            int roomsAmount=0;
            Random rand =new Random();
            int chance = rand.nextInt(10);
            if (chance<2) {
                roomsAmount = 1;
            }
            else if(chance<6){
                roomsAmount =2;
            }
            else{
                roomsAmount=3;
            }

            for(int j=0;j<roomsAmount;j++) {
                chance = rand.nextInt(11);
                if( chance <= 6) {
                    currRooms.add(new EncounterRoom(RoomType.ENCOUNTER,i,j));
                }
                else if(chance<=7) {
                    currRooms.add(new Attributes.LootRoom(RoomType.LOOT,i,j));
                }
                else if(chance<10) {
                    currRooms.add(new TestRoom(RoomType.TEST,i,j));
                }
                else {
                    currRooms.add(new EmptyRoom(RoomType.EMPTYROOM,i,j));
                }
            }
            int parents=predRooms.size();
            int children=currRooms.size();
            System.out.println(parents+ " "+children+" "+ i+" current");
            List<Corridor> corridors= new ArrayList<>();
            for (int j=0;j<parents;j++){
                int ending = rand.nextInt(children);
                System.out.println(j+" "+ending+" do dziecka");
                corridors.add(new Corridor(j,ending));
            }
            for (int j=0;j<children;j++){
                int begginings = rand.nextInt(parents);
                System.out.println(begginings+" "+j+" do ojca");
                corridors.add(new Corridor(begginings,j));
            }

            Set<Corridor> corridorSet= new HashSet<>(corridors);
            corridors = new ArrayList<>(corridorSet);

            for (Corridor corridor : corridors){
                System.out.println(corridor.toString());
                predRooms.get(corridor.getBeg()).addChildNeigbour(currRooms.get(corridor.getEnd()));
                currRooms.get(corridor.getEnd()).addParentNeigbour(predRooms.get(corridor.getBeg()));
            }

            allRooms.addAll(currRooms);
            predRooms=currRooms;
        }

        EncounterRoom encounterRoom= new EncounterRoom(RoomType.ENCOUNTER,size,0);
        for (AbstractRoom room : predRooms){
            room.addChildNeigbour(encounterRoom);
            encounterRoom.addParentNeigbour(room);
        }
        allRooms.add(encounterRoom);

    }

    public void representation(){
        for(AbstractRoom room : allRooms){
            System.out.println(room);
        }
    }



}
