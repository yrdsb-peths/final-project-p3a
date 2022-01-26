import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The second level in the game
 * 
 * @author Isaac, Kenneth
 * @version 1
 */
public class LevelTwo extends World
{

    /**
     * Constructor for objects of class LevelTwo.
     * 
     */
    //generate the map
    private TerrainGen tGenerator = new TerrainGen("LevelTwoMap.txt");
    /**
     * Constructor for objects of class levelOne.
     * 
     */
    public LevelTwo()
    {
        // Create a new world with 384*3x193*3 cells with a cell size of 1x1 pixels.
        super(384*3, 192*3, 1);
        
        //set background
        GreenfootImage bg = new GreenfootImage("leveltwo.png");
        bg.scale(384*3, 192*3);
        setBackground(bg);
        
        //add player to world
        Player player = new Player("LevelTwo");
        addObject(player, 100, 100);
        
        //add hitbox detection to player for collectables and spikes
        HitboxVisualizer hitbox = new HitboxVisualizer(player);
        addObject(hitbox, 0, 0);
        
        tGenerator.createMap(player);
        Utilities.drawHP(player);
        Utilities.drawScore(player);
    }
}