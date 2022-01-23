import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class levelOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelOne extends World
{
    private TerrainGen tGenerator = new TerrainGen("LevelOneMap.txt");
    /**
     * Constructor for objects of class levelOne.
     * 
     */
    public LevelOne()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(384*3, 192*3, 1);
        GreenfootImage bg = new GreenfootImage("levelone.png");
        bg.scale(384*3, 192*3);
        setBackground(bg);
        Player player = new Player("LevelOne");
        addObject(player, 48, 504);
        tGenerator.createMap(player);
    }
}
