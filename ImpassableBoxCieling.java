import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ImpassableBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImpassableBoxCieling extends Actor
{
    public ImpassableBoxCieling(int width, int height)
    {
        // Creates an invisible box
        GreenfootImage boundingBox = new GreenfootImage(width, height);
        setImage(boundingBox);
        
        //code to see the bounding boxes
        boundingBox.setColor(new Color(0, 0, 255)); 
        boundingBox.fill();
    }
}