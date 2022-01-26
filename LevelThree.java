import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The third level in the game
 * 
 * @author Iaac, Kenneth 
 * @version 1
 */
public class LevelThree extends World
{
    //generate the map
    private TerrainGen tGenerator = new TerrainGen("LevelThreeMap.txt");
    /**
     * Constructor for objects of class LevelThree.
     * 
     */
    public LevelThree()
    {    
        // Create a new world with 384*3x193*3 cells with a cell size of 1x1 pixels.
        super(384*3, 193*3, 1);
        
        //set background
        GreenfootImage bg = new GreenfootImage("LevelThree.png");
        bg.scale(384*3, 192*3);
        setBackground(bg);
        
        //add player to world
        Player player = new Player("LevelThree");
        addObject(player, 48, 312);
        
        //add hitbox detection to player for collectables and spikes
        HitboxVisualizer hitbox = new HitboxVisualizer(player);
        addObject(hitbox, 0, 0);
        
        tGenerator.createMap(player);
        Utilities.drawHP(player);
        Utilities.drawScore(player);
    }
}