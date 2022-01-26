import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The tutorial world of the game
 * 
 * @author Isaac, Kenneth
 * @version 1
 */
public class Tutorial extends World
{
    ///generate map
    private TerrainGen tGenerator = new TerrainGen("TutorialMap.txt");
    /**
     * Constructor for objects of class Tutorial.
     * 
     */
    public Tutorial()
    {    
        // Create a new world with 384*3x193*3 cells with a cell size of 1x1 pixels.
        super(384*3, 192*3, 1); 
        
        //set background
        GreenfootImage bg = new GreenfootImage("tutorial.png");
        bg.scale(384*3, 192*3);
        setBackground(bg);
        
        //add player to world
        Player player = new Player("Tutorial");
        addObject(player, 200, 528);
        
        //add hitbox detection to player for collectables and spikes
        HitboxVisualizer hitbox = new HitboxVisualizer(player);
        addObject(hitbox, 0, 0); 
        
        tGenerator.createMap(player);
        Utilities.drawHP(player);
        Utilities.drawScore(player);
    }
}
