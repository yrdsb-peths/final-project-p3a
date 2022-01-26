import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates a void that will damage player
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EmptyVoid extends Actor
{
    // Class to create void that will damage player
    public EmptyVoid(int width, int height)
    {
        // Creates an invisible box
        GreenfootImage emptyVoid = new GreenfootImage(width, height);
        setImage(emptyVoid);
        
        //code to see the void
        //emptyVoid.setColor(new Color(150, 60, 255)); 
        //emptyVoid.fill();
        
    }
}
