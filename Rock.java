import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends AbstOther
{
    
    public Rock(int speed){
        super(0);
    }
    
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void interact(Frogger player){
        if (intersects(player) && width>0){
            img = getImage();
            width = img.getWidth()-2;
            height = img.getHeight()-2;
            if(width > 20){
                
                img.scale(width, height);    
            }
            else{
                img.setTransparency(0);
            }
                
            
            
        }
    }
}
