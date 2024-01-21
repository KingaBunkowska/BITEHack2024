package oop.model;

import oop.model.dungeon.*;
import oop.model.entities.*;
import oop.model.loot.Loot;
import oop.model.loot.LootGenerator;

import java.util.*;

public class Game {

    private List<Enemy> enemies;
    private Dungeon dungeon;
    private Party party;

    public Game(){
        this.initializeDungeon();
        this.initializeParty();
    }

    public void simulateTurn(AbstractRoom room){
        party.move(room);
        if (room.roomType==RoomType.ENCOUNTER){
            EncounterRoom encounterRoom = (EncounterRoom) room;
            Enemy enemy = encounterRoom.getEnemy();
            SimulationOfFight simulation = new SimulationOfFight(party, enemy);
            boolean isFightWon = simulation.simulateFight();

            if (isFightWon){
                generateLoot(enemy.getLevel(), (float) encounterRoom.column / dungeon.getAllRooms().size());

            }
        }

        else if(room.roomType==RoomType.LOOT){
            generateLoot(3*room.column, (float) room.column / dungeon.getAllRooms().size());
        }
        else if(room.roomType==RoomType.TEST){
            TestRoom testRoom = (TestRoom) room;
            testRoom.startTest(party);
        }

        if (room.column == Dungeon.getSize()-1){
            triggerEndOfGame();
        }

    }

    private void triggerEndOfGame() {
        if (party.getHeroes().stream().mapToInt(Entity::getHealth).sum() <= party.getHeroes().stream().mapToInt(entity-> entity.getAttributes().getMaxHealth()).sum()){
            System.out.println("GAME WON! "+ party.getValue());
        }
        else{
            System.out.println("GAME OVER");
        }
    }

    private void generateLoot(int level, float p) {
        List<Loot> loots = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            Loot loot = LootGenerator.getRandomLootItem(level, p);
            loots.add(loot);
        }

        Loot lootChosen = loots.get(1); //this has to change into something from UI
        Hero heroChosen = this.party.getHeroes().get(1); //change to UI value

        party.addValue(heroChosen.useItemReturnValue(lootChosen));
    }

    public void initializeDungeon(){
        Dungeon dungeon = new Dungeon(7);
        this.dungeon = dungeon;
        List<AbstractRoom> rooms = dungeon.getAllRooms();
        List<EncounterRoom> encounterRooms = rooms.stream().filter(room->room.roomType == RoomType.ENCOUNTER).map(room->(EncounterRoom)room).toList();

        this.enemies = interactivelyMakeEnemies(encounterRooms.size());

        this.populateDungeons(enemies, encounterRooms);
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public void initializeParty(){
        List<Hero> heroes = new LinkedList<>();

        for (int i=0; i<4; i++){
            heroes.add(new Hero());
        }

        this.party = new Party(heroes, dungeon.getFirstRoom());

    }

    private void populateDungeons(List<Enemy> enemies, List<EncounterRoom> rooms) {

        int i=0;

        for (EncounterRoom room: rooms){
            room.addEnemy(enemies.get(i));
            i+=1;
        }

    }

    private List<Enemy> interactivelyMakeEnemies(int n){

        List<Enemy> enemies = new ArrayList<>();

        for (int i=0; i<n; i++){

            int power = 10;
            Kind kind = Kind.SCARY_CAT;
            CallOf callOf = CallOf.MYSTERY;
            int maxHealth = 50;

            Enemy enemy = new Enemy(power, kind, callOf, maxHealth);
            enemies.add(enemy);
        }

        Collections.shuffle(enemies);
        return enemies;
    }

    private void endGame(){
        System.out.println("GAME OVER");

    }


}
