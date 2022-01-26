import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spike here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spike extends Actor
{
    // Spike hitbox class
    public Spike()
    {
        GreenfootImage boundingBox = new GreenfootImage(21, 18);
        setImage(boundingBox);
        
        boundingBox.setColor(new Color(128, 128, 128));
        boundingBox.setTransparency(80);
        //boundingBox.fill();
    }
}
