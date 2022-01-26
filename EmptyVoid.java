import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EmptyVoid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EmptyVoid extends Actor
{
    public EmptyVoid(int width, int height)
    {
        // Creates an invisible box
        GreenfootImage emptyVoid = new GreenfootImage(width, height);
        setImage(emptyVoid);
        
        //code to see the bounding boxes
        emptyVoid.setColor(new Color(150, 60, 255)); 
        //emptyVoid.fill();
    }
}
