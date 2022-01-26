import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tutorial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutorial extends World
{
    private TerrainGen tGenerator = new TerrainGen("TutorialMap.txt");
    /**
     * Constructor for objects of class Tutorial.
     * 
     */
    public Tutorial()
    {    
        super(384*3, 192*3, 1); 
        GreenfootImage bg = new GreenfootImage("tutorial.png");
        bg.scale(384*3, 192*3);
        setBackground(bg);
        
        Player player = new Player("Tutorial");
        addObject(player, 200, 528);
        
        HitboxVisualizer hitbox = new HitboxVisualizer(player);
        addObject(hitbox, 0, 0); 
        
        tGenerator.createMap(player);
        Utilities.drawHP(player);
        Utilities.drawScore(player);
    }
}
