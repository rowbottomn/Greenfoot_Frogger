import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Frogger here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Frogger extends Actor
{
    int leapSize = 50;
    final int keyCooldown = 8;
    private int keyTimer = 0;
    GreenfootImage img;
    Game world;

    public Frogger(){
        img = getImage();
        img.scale(leapSize, leapSize);

    }

    /**
     * Act - do whatever the Frogger wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(world == null){
            world = (Game)getWorld();
            //reset rotation and position
            reset();

        }

        //get input from the user
        getKeys();        
        //update the position

        //check to see if its dead or off the screen

    }

    protected void getKeys(){
        if(keyTimer>keyCooldown){
            if(Greenfoot.isKeyDown("a")){
                setRotation(180);   
                move(leapSize);
            }
            else if(Greenfoot.isKeyDown("w")){
                setRotation(-90);
                move(leapSize);
            }
            else if(Greenfoot.isKeyDown("d")){
                setRotation(0);
                move(leapSize);
            }
            else if(Greenfoot.isKeyDown("s")){
                setRotation(90);
                move(leapSize);
            }
            keyTimer = 0;
        }
        keyTimer++;

        
    }

    protected void reset(){
        setRotation(-90);
        setLocation(world.getWidth()/2, world.getHeight()-img.getHeight()/2);
    }
    
    protected void die(){
        world.lives--;
        world.addObject(new Corpse(this), getX(), getY());
        
        reset();
    }
    
}
