import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends World
{
    Start titleScreen;
    GreenfootSound bgmusic;
    Frogger player;
    int lives;
    int numCars = 3;
    Car[] cars1 = new Car[numCars];
    Car[] cars2 = new Car[numCars];
    int numRocks = 15;
    int numLogs1 = 3; //logs going right
    int numLogs2 = 2; //logs going left
    Log[] logs1 = new Log[numLogs1];
    Log[] logs2 = new Log[numLogs2];
    
    Rock[] rocks = new Rock[numRocks];
    Road road1;
    Road road2;
    River river;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1, false);
        setPaintOrder(Car.class, Frogger.class,Rock.class, Log.class);
        reset();
        titleScreen = new Start(this);
        Greenfoot.setWorld(titleScreen);
    }
    
    public void act(){
        if(bgmusic ==null){
            bgmusic = titleScreen.titleTrack;
        }
        showText("Lives:" +lives, 50, 20);
       // player.move(5);
       // if(player.getX()>this.getWidth()){
       //     player.setLocation(0, player.getY());
            
       // }
       
       List<Rock> allRocks = getObjects(Rock.class);
       for(Rock rock : allRocks){
           //System.out.println(""+rock.getX()+", "+rock.getY());
       }
       List<Car> allCars = getObjects(Car.class);
       for(Car car : allCars){
         car.interact(player);  
       }
        List<Log> allLogs = getObjects(Log.class);
       for(Log log : allLogs){
         log.interact(player);  
       }
       
    }
    
    public void reset(){
        player = new Frogger();
        lives = 3;
        addObject(player, getWidth()/2, getHeight()-25);
        
        for(int i=0; i < numCars; i++){
            cars1[i] = new Car(5);
            addObject(cars1[i], 100 + i*200, getHeight() - 125);
        }
        for(int i=0; i < numCars; i++){
            cars2[i] = new Car(3);
            cars2[i].setRotation(180);
            addObject(cars2[i], 100 + i*250, getHeight() - 225);
        }
        //make the logs going right
        for(int i=0; i < numLogs1; i++){
            logs1[i] = new Log(3, 100, 50);
            addObject(logs1[i], 50 + i*200, 275);
        }
        //make the logs going left
        for(int i=0; i < numLogs1; i++){
            logs1[i] = new Log(-1, 100, 50);
            addObject(logs1[i], 50 + i*200, 125);
        }
        
        for(int i=0; i < 5; i++){
            rocks[i] = new Rock(0);
            addObject(rocks[i], 100 + i*200, 325);
        }
        
        for(int i=5; i < 10; i++){
            rocks[i] = new Rock(0);
            addObject(rocks[i], 100 + (i-5)*200, 75);
        }
        for(int i=10; i < 15; i++){
            rocks[i] = new Rock(0);
            addObject(rocks[i], 50 + (i-10)*200, 200);
        }
        road1 = new Road();
        addObject(road1, getWidth()/2, getHeight()-100);
        road2 = new Road();
        addObject(road2, getWidth()/2, getHeight()-250);
        
        river = new River();
        addObject(river, getWidth()/2, 200);
        
    }
    
}
