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
        super(512*2, 288*2, 1); 
        GreenfootImage bg = new GreenfootImage("TiledMap.png");
        //bg.scale(512*2, 288*2);
        setBackground(bg);
        Player player = new Player();
        addObject(player, 100, 100);
    }
}
