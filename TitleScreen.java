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
        super(384*3, 192*3, 1);
        GreenfootImage bg = new GreenfootImage("TitleScreen.png");
        bg.scale(384*3, 192*3);
        setBackground(bg);
        
        Play playTag = new Play();
        addObject(playTag, getWidth()/2, (getHeight()/5)*4);
        
        // Reset variables
        Player.spawn[0] = 200;
        Player.spawn[1] = 528;
        for (int i = 0; i < Player.lives.length; i++)
        {
            Player.lives[i].updateStatus(true);
        }
        Sounds.stopBGM("Lose.mp3");
        Sounds.stopBGM("Win.mp3");
        Player.score = 0;
    }
    public void started()
    {
        Sounds.setBGM("BGM.mp3");
    }
    public void act(){
        if (Greenfoot.isKeyDown("space")){
            Tutorial curWorld = new Tutorial();
            Greenfoot.setWorld(curWorld);
        }
    }
}
