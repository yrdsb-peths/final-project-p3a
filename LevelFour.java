import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The fourth level in the game
 * 
 * @author Isaac, Kenneth
 * @version 1
 */
public class LevelFour extends World
{
    //generate the map
    TerrainGen tGenerator = new TerrainGen("LevelFourMap.txt");
    /**
     * Constructor for objects of class LevelFour.
     * 
     */
    public LevelFour()
    {    
        // Create a new world with 384*3x193*3 cells with a cell size of 1x1 pixels.
        super(384*3, 193*3, 1);
        // set background
        GreenfootImage bg = new GreenfootImage("LevelFour.png");
        bg.scale(384*3, 192*3);
        setBackground(bg);
        
        //add player to world
        Player player = new Player("LevelFour");
        addObject(player, 48, 240);
        
        //add hitbox detection to player for collectables and spikes
        HitboxVisualizer hitbox = new HitboxVisualizer(player);
        addObject(hitbox, 0, 0);
        
        tGenerator.createMap(player);
        Utilities.drawHP(player);
        Utilities.drawScore(player);
    }
}