import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates a floor so player cannot fall through something
 * 
 * @author Isaac, Kenneth
 * @version 1
 */
public class ImpassableBoxFloor extends Actor
{
    // Floor class so player does not fall through something
    public ImpassableBoxFloor(int width, int height)
    {
        // Creates an invisible box
        GreenfootImage boundingBox = new GreenfootImage(width, height);
        setImage(boundingBox);
        
        //code to see the bounding boxes
        //boundingBox.setColor(new Color(255, 0, 0)); 
        //boundingBox.fill();
    }
}
