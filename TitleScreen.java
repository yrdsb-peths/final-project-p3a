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
        
        // Reset variables
        Player.spawn[0] = 200;
        Player.spawn[1] = 528;
    }
    public void act(){
        Player.spawn[0] = 200;
        Player.spawn[1] = 528;
        if ("space".equals(Greenfoot.getKey())){
            LevelTwo curWorld = new LevelTwo();
            Greenfoot.setWorld(curWorld);
        }
    }
}
