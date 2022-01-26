import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The screen that shows when you win
 * 
 * @author Isaac, Kenneth
 * @version 1
 */
public class Win extends World
{
    public Win()
    {    
        // Create a new world with 384*3x193*3 cells with a cell size of 1x1 pixels.
        super(384*3, 192*3, 1);
        
        //sets background
        GreenfootImage bg = new GreenfootImage("Win.png");
        bg.scale(384*3, 192*3);
        setBackground(bg);
        
        Player.score = (int)((Player.score) * 1.5);
        
        //stops music
        Sounds.stopBGM("BGM.mp3");
    }
    public void act()
    {
        //plays win theme
        Sounds.setBGM("Win.mp3");
        
        //registers score based off user input
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
