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
        for (int i = 0; i < Player.lives.length; i++)
        {
            Player.lives[i].updateStatus(true);
        }
        Player.score = 0;
    }
    public void act(){
        if ("space".equals(Greenfoot.getKey())){
            Tutorial curWorld = new Tutorial();
            Greenfoot.setWorld(curWorld);
        }
    }
}
