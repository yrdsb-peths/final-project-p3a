import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates a box that goes to the next level if touched
 * 
 * @author Isaac, Kenneth
 * @version 1
 */
public class NextLevel extends Actor
{
    // Class to handle collision for transition to next area
    public NextLevel(int width, int height)
    {
        // Creates an invisible box
        GreenfootImage nextLevel = new GreenfootImage(width, height);
        setImage(nextLevel);
        
        //code to see the bounding boxes
        //nextLevel.setColor(new Color(255, 255, 182)); 
        //nextLevel.fill();
    }
}
