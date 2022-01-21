import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelTwo extends World
{

    /**
     * Constructor for objects of class LevelTwo.
     * 
     */
    private TerrainGen tGenerator = new TerrainGen("levelOneMap.txt");
    /**
     * Constructor for objects of class levelOne.
     * 
     */
    public LevelTwo()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(384*3, 192*3, 1);
        GreenfootImage bg = new GreenfootImage("untitled3.png");
        bg.scale(384*3, 192*3);
        setBackground(bg);
        Player player = new Player("LevelTwo");
        addObject(player, 100, 100);
        tGenerator.createMap(player);
    }
}
