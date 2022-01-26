import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ImpassableBoxFloor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        boundingBox.setColor(new Color(255, 0, 0)); 
        //boundingBox.fill();
    }
}
