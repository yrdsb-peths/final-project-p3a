import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates a ceiling so player cannot jump through something
 * 
 * @author Isaac, Kenneth
 * @version 1
 */
public class ImpassableBoxCeiling extends Actor
{
    // Ceiling class so player cannot jump through something
    public ImpassableBoxCeiling(int width, int height)
    {
        // Creates an invisible box
        GreenfootImage boundingBox = new GreenfootImage(width, height);
        setImage(boundingBox);
        
        //code to see the bounding boxes
        //boundingBox.setColor(new Color(0, 0, 255)); 
        //boundingBox.fill();
    }
}
