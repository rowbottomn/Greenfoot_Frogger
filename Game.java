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

    Frogger player;
    
    int numCars = 3;
    Car[] cars1 = new Car[numCars];
    Car[] cars2 = new Car[numCars];
    int numRocks = 15;
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
        player = new Frogger();
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
            addObject(rocks[i], 50 + (i-10)*200, 225);
        }
        road1 = new Road();
        addObject(road1, getWidth()/2, getHeight()-100);
        road2 = new Road();
        addObject(road2, getWidth()/2, getHeight()-250);
        
        river = new River();
        addObject(river, getWidth()/2, 200);
        
        
    }
    
    public void act(){
       // player.move(5);
       // if(player.getX()>this.getWidth()){
       //     player.setLocation(0, player.getY());
            
       // }
       
       List<Rock> allRocks = getObjects(Rock.class);
       for(Rock rock : allRocks){
           System.out.println(""+rock.getX()+", "+rock.getY());
       }
       
    }
    
}
