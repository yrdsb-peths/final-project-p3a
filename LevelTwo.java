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
    private TerrainGen tGenerator = new TerrainGen("LevelTwoMap.txt");
    /**
     * Constructor for objects of class levelOne.
     * 
     */
    public LevelTwo()
    {
        super(384*3, 192*3, 1);
        GreenfootImage bg = new GreenfootImage("leveltwo.png");
        bg.scale(384*3, 192*3);
        setBackground(bg);
        
        Player player = new Player("LevelTwo");
        addObject(player, 100, 100);
        
        HitboxVisualizer hitbox = new HitboxVisualizer(player);
        addObject(hitbox, 0, 0);
        
        tGenerator.createMap(player);
        Utilities.drawHP(player);
        Utilities.drawScore(player);
    }
}
