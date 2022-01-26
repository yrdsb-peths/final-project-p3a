import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The screen that shows when you die
 * 
 * @author Isaac, Kenneth
 * @version 1
 */
public class Lose extends World
{

    /**
     * Constructor for objects of class Lose.
     * 
     */
    public Lose()
    {    
        //creates a world 384*3x192*3 cells with a cell size of 1x1 pixels
        super(384*3, 192*3, 1);
        
        //sets the background
        GreenfootImage bg = new GreenfootImage("Lose.png");
        bg.scale(384*3, 192*3);
        setBackground(bg);
        
        //stops the game music
        Sounds.stopBGM("BGM.mp3");
    }
    public void act()
    {
        //plays the lose theme
        Sounds.setBGM("Lose.mp3");
        //registers score if requested
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
