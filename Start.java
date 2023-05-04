import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends World
{
    Game game;
    GreenfootSound titleTrack;
    GifImage frogger;
    UiElement title;
    /**
     * Constructor for objects of class Start.
     * 
     */
    public Start(Game g)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        game = g;
        frogger = new GifImage("title.gif");
        title = new UiElement(frogger, 400, 150);
        addObject(title, getWidth()/2, 150);
    }
    
    public void act(){
        if(titleTrack == null){
            titleTrack = new GreenfootSound("funnysong.mp3");
            titleTrack.playLoop();
        }
        showText("Press Start to Continue", getWidth()/2, 500);
        String key = Greenfoot.getKey();
        if (key!= null){
            if(key.equals("space")){
                Greenfoot.setWorld(game);
            }
            else if(key.equals("p")){
                //is the sound playing?
                if(titleTrack.isPlaying()){
                   titleTrack.pause(); 
                }
                else{
                    titleTrack.playLoop();
                }
            }
        }
        
        
        
    }
}
