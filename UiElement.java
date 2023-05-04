import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UiElement here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UiElement extends Actor
{
    private GifImage gif;
    private int width =-99;
    private int height = -99;
    public UiElement(GifImage gif){
        this.gif = gif;
    }
    
    public UiElement(GifImage gif, int w, int h){
        this.gif = gif;
        width = w; 
        height = h;
    }
    
    /**
     * Act - do whatever the UiElement wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        GreenfootImage current = gif.getCurrentImage();
        if(width !=-99){
           current.scale(width, height);
        }
        setImage(current);
    }
}
