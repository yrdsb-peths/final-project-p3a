import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class levelOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelOne extends World
{
    private static ImpassableBox impassableBox[] = new ImpassableBox[1152];
    private int tileSize = 24;
    private int cols = 48;
    private int offset = tileSize/2;
    public void createMap(int[] map){
        for(int i = 0; i < map.length; i++){
            if(map[i] == 1){
                impassableBox[i] = new ImpassableBox (tileSize,tileSize);
                addObject(impassableBox[i], i % cols * tileSize + offset ,(int)Math.floor(i/cols) * tileSize + offset);
            }
        }
    }
    
    /**
     * Constructor for objects of class levelOne.
     * 
     */
    public LevelOne()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(384*3, 192*3, 1);
        GreenfootImage bg = new GreenfootImage("untitled2.png");
        bg.scale(384*3, 192*3);
        setBackground(bg);
        Player player = new Player();
        addObject(player, 100, 100);
        createMap(MapReader.fromFile("maps.txt"));
    }
}
