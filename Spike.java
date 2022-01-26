import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates a spike hitbox
 * 
 * @author Isaac, Kenneth
 * @version 1
 */
public class Spike extends Actor
{
    // Spike hitbox class
    public Spike()
    {
        GreenfootImage boundingBox = new GreenfootImage(21, 18);
        setImage(boundingBox);
        
        //code to see hitbox
        //boundingBox.setColor(new Color(128, 128, 128));
        //boundingBox.setTransparency(80);
        //boundingBox.fill();
    }
}
