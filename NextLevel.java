import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NextLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NextLevel extends Actor
{
    public NextLevel(int width, int height)
    {
        // Creates an invisible box
        GreenfootImage nextLevel = new GreenfootImage(width, height);
        setImage(nextLevel);
        
        //code to see the bounding boxes
        nextLevel.setColor(new Color(255, 255, 182)); 
        nextLevel.fill();
    }
}
