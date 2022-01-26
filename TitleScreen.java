import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The title screen of the game
 * 
 * @author Isaac, Kenneth 
 * @version 1
 */
public class TitleScreen extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public TitleScreen()
    {   
        // Create a new world with 384*3x193*3 cells with a cell size of 1x1 pixels.
        super(384*3, 192*3, 1);
        
        //sets background
        GreenfootImage bg = new GreenfootImage("TitleScreen.png");
        bg.scale(384*3, 192*3);
        setBackground(bg);
        
        // The play button
        Play playTag = new Play();
        addObject(playTag, getWidth()/2, (getHeight()/5)*4);
        
        // Reset variables
        Player.spawn[0] = 200;
        Player.spawn[1] = 528;
        for (int i = 0; i < Player.lives.length; i++)
        {
            Player.lives[i].updateStatus(true);
        }
        Sounds.stopBGM("Lose.mp3"); // Stop old music
        Sounds.stopBGM("Win.mp3");
        Player.score = 0;
    }
    public void started()
    {
        //starts music
        Sounds.setBGM("BGM.mp3");
    }
    public void act(){
        //proceeds with game if spacebar is pressed
        if (Greenfoot.isKeyDown("space")){
            Tutorial curWorld = new Tutorial();
            Greenfoot.setWorld(curWorld);
        }
    }
}
