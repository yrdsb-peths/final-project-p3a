import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Isaac, Kenneth 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
    }
    public void act(){
        if ("space".equals(Greenfoot.getKey())){
            LevelOne curWorld = new LevelOne();
             
            
            Greenfoot.setWorld(curWorld);
        }
    }
}
