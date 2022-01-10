import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class levelOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class levelOne extends World
{

    /**
     * Constructor for objects of class levelOne.
     * 
     */
    public levelOne()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super((int)Math.round(512*2.5), (int)Math.round(288*2.5), 1); 
        GreenfootImage bg = new GreenfootImage("TiledMap (2).png");
        bg.scale((int)Math.round(512*2.5), (int)Math.round(288*2.5));
        setBackground(bg);
        Player player = new Player();
        addObject(player, 100, 100);
    }
}
