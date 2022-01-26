import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates a right wall so a player cannot continue walking left
 * 
 * @author Isaac, Kenneth
 * @version 1
 */
public class ImpassableBoxRightSide extends Actor
{
    // Right side wall class so player cannot walk through right side of something
    public ImpassableBoxRightSide(int width, int height)
    {
        // Creates an invisible box
        GreenfootImage boundingBox = new GreenfootImage(width, height);
        setImage(boundingBox);
        
        //code to see the bounding boxes
        //boundingBox.setColor(new Color(255, 255, 0)); 
        //boundingBox.fill();
    }
}
