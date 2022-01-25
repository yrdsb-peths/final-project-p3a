import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelFour here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelFour extends World
{
    TerrainGen tGenerator = new TerrainGen("LevelFourMap.txt");
    /**
     * Constructor for objects of class LevelFour.
     * 
     */
    public LevelFour()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(384*3, 193*3, 1);
        GreenfootImage bg = new GreenfootImage("LevelFour.png");
        bg.scale(384*3, 192*3);
        setBackground(bg);
        
        Player player = new Player("LevelFour");
        addObject(player, 48, 312);
        
        HitboxVisualizer hitbox = new HitboxVisualizer(player);
        addObject(hitbox, 0, 0);
        
        tGenerator.createMap(player);
        Utilities.drawHP(player);
        Utilities.drawScore(player);
    }
}
