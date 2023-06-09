import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Has 
 * speed
 * width height
 * world, img
 * 
 * Does
 * move to the side 
 * resets to the other side
 * interacts with the player
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class AbstOther extends Actor
{
    protected int speed;
    protected int width;
    protected int height;
    protected Game world;
    protected GreenfootImage img;
    
    public AbstOther(int speed){
        this.speed = speed;
    }
    
    public AbstOther(int speed, int w, int h){
        this.speed = speed;
        this.width = w;
        this.height = h;
        img = getImage();
        img.scale(width, height);
    }
    
    /**
     * Act - do whatever the AbstOther wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (world == null){
            world = (Game)getWorld();
        }
        //move it by speed
        move(speed);
        //if it reaches the edge of the screen
        if(getX()>world.getWidth()){
            //set it to the the side
            setLocation(0, getY());
        }
        else if(getX()<0){
            setLocation(world.getWidth(), getY());
        }
            
    }
    
    public abstract void interact(Frogger player);
}
