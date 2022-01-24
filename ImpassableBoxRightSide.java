import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ImpassableBoxRightSide here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImpassableBoxRightSide extends Actor
{
    public ImpassableBoxRightSide(int width, int height)
    {
        // Creates an invisible box
        GreenfootImage boundingBox = new GreenfootImage(width, height);
        setImage(boundingBox);
        
        //code to see the bounding boxes
        boundingBox.setColor(new Color(255, 255, 0)); 
        //boundingBox.fill();
    }
}
