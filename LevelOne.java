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
    private static ImpassableBoxSide impassableBoxLeftSide[] = new ImpassableBoxSide[1152];
    private static ImpassableBoxSide impassableBoxRightSide[] = new ImpassableBoxSide[1152];
    private static ImpassableBoxFloor impassableBoxFloor[] = new ImpassableBoxFloor[1152];
    private static ImpassableBoxFloor impassableBoxFloorTop[] = new ImpassableBoxFloor[1152];
    private int tileSize = 24;
    private int floorSideWidth = 1;
    private int cols = 48;
    private int offset = tileSize/2;
    
    public void createMap(int[] map){
        for(int i = 0; i < map.length; i++){
            if(map[i] == 1){
                impassableBox[i] = new ImpassableBox (100,1);
                //addObject(impassableBox[i], i % cols * tileSize + offset ,(int)Math.floor(i/cols) * tileSize + offset);
                addObject(impassableBox[i], 100,75);
            }
            if(map[i] == 2){
                impassableBoxLeftSide[i] = new ImpassableBoxSide(floorSideWidth,tileSize);
                impassableBoxRightSide[i] = new ImpassableBoxSide(floorSideWidth,tileSize);
                addObject(impassableBoxLeftSide[i], i % cols * tileSize,(int)Math.floor(i/cols) * tileSize + offset);
                addObject(impassableBoxRightSide[i], i % cols * tileSize + offset*2,(int)Math.floor(i/cols) * tileSize + offset);
            }
            if(map[i] == 3){
                impassableBoxFloor[i] = new ImpassableBoxFloor(tileSize,floorSideWidth);
                impassableBoxFloorTop[i] = new ImpassableBoxFloor(tileSize,floorSideWidth);
                addObject(impassableBoxFloor[i], i % cols * tileSize + offset,(int)Math.floor(i/cols) * tileSize);
                addObject(impassableBoxFloorTop[i], i % cols * tileSize + offset,(int)Math.floor(i/cols) * tileSize + offset*2);
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
