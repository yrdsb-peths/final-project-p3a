import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lose here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lose extends World
{

    /**
     * Constructor for objects of class Lose.
     * 
     */
    public Lose()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(384*3, 192*3, 1);
        GreenfootImage bg = new GreenfootImage("Lose.png");
        bg.scale(384*3, 192*3);
        setBackground(bg);
        Sounds.stopBGM("BGM.mp3");
    }
    public void act()
    {
        Sounds.setBGM("Lose.mp3");
        if (Greenfoot.isKeyDown("y"))
        {
            Scores.registerScore(Player.score);
            Scores gameWorld = new Scores();
            Greenfoot.setWorld(gameWorld);
        }
        else if (Greenfoot.isKeyDown("n"))
        {
            Scores gameWorld = new Scores();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
