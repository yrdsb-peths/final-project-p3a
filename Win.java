import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Win here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Win extends World
{
    public Win()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(384*3, 192*3, 1);
        GreenfootImage bg = new GreenfootImage("Win.png");
        bg.scale(384*3, 192*3);
        setBackground(bg);
        Player.score = (int)((Player.score) * 1.5);
        Sounds.stopBGM("BGM.mp3");
    }
    public void act()
    {
        Sounds.setBGM("Win.mp3");
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
