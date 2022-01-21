import greenfoot.*;
/**
 * Write a description of class TerrainGen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TerrainGen extends Actor 
{
    // Array to hold the possible locations (tiles) of an ImpassableBox actor
    // There are 1152 possible locations, 48 tiles x 24 tiles
    private static ImpassableBoxLeftSide impassableBoxLeftSideArray[] = new ImpassableBoxLeftSide[1152];
    private static ImpassableBoxRightSide impassableBoxRightSideArray[] = new ImpassableBoxRightSide[1152];
    private static ImpassableBoxFloor impassableBoxFloorArray[] = new ImpassableBoxFloor[1152];
    private static ImpassableBoxCeiling impassableBoxCeilingArray[] = new ImpassableBoxCeiling[1152];
    private static EmptyVoid emptyVoidArray[] = new EmptyVoid[1152];
    private static NextLevel nextLevelArray[] = new NextLevel[1152];
    private int tileSize = 24; // Tiles are 24 x 24 pixels
    private int drawnTileSize = 20; //Drawn tiles are 20 x 20 pixels to prevent overlapping tiles
    private int platformTileSize = 12;
    private int cols = 48; // The map is 48 tiles wide
    private int offset = tileSize/2; // Greenfoot drawing offset
    private int floorSideWidth = 1;
    private int[] map;
    private World world;
    /**
     * Constructor for objects of class TerrainGen
     */
    public TerrainGen(String mapName)
    {
        this.map = MapReader.fromFile(mapName);
    }
    public void createMap(Player pc){
        for(int i = 0; i < map.length; i++){
            if(map[i] == 1){
                impassableBoxLeftSideArray[i] = new ImpassableBoxLeftSide(floorSideWidth,drawnTileSize);
                impassableBoxRightSideArray[i] = new ImpassableBoxRightSide(floorSideWidth,drawnTileSize);
                impassableBoxCeilingArray[i] = new ImpassableBoxCeiling(drawnTileSize,floorSideWidth);
                impassableBoxFloorArray[i] = new ImpassableBoxFloor(drawnTileSize,floorSideWidth);
                pc.getWorld().addObject(impassableBoxLeftSideArray[i], i % cols * tileSize,(int)Math.floor(i/cols) * tileSize + offset);
                pc.getWorld().addObject(impassableBoxRightSideArray[i], i % cols * tileSize + offset*2,(int)Math.floor(i/cols) * tileSize + offset);
                pc.getWorld().addObject(impassableBoxFloorArray[i], i % cols * tileSize + offset,(int)Math.floor(i/cols) * tileSize);
                pc.getWorld().addObject(impassableBoxCeilingArray[i], i % cols * tileSize + offset,(int)Math.floor(i/cols) * tileSize + offset*2);
            }
            if(map[i] == 2){
                impassableBoxFloorArray[i] = new ImpassableBoxFloor(platformTileSize,floorSideWidth+10);
                impassableBoxLeftSideArray[i] = new ImpassableBoxLeftSide(floorSideWidth,floorSideWidth);
                impassableBoxCeilingArray[i] = new ImpassableBoxCeiling(platformTileSize,floorSideWidth);
                pc.getWorld().addObject(impassableBoxFloorArray[i], i % cols * tileSize + offset,(int)Math.floor(i/cols) * tileSize);
                //pc.getWorld().addObject(impassableBoxLeftSideArray[i], i % cols * tileSize + offset,(int)Math.floor(i/cols) * tileSize + 3);
                pc.getWorld().addObject(impassableBoxCeilingArray[i], i % cols * tileSize + offset,(int)Math.floor(i/cols) * tileSize + 6);
            }
            if(map[i] == 3){
                emptyVoidArray[i] = new EmptyVoid(tileSize,floorSideWidth);
                pc.getWorld().addObject(emptyVoidArray[i], i % cols * tileSize + offset, (int)Math.floor(i/cols) * tileSize + offset);
            }
            if(map[i] == 4){
                nextLevelArray[i] = new NextLevel(drawnTileSize, drawnTileSize);
                pc.getWorld().addObject(nextLevelArray[i], i % cols * tileSize + offset, (int)Math.floor(i/cols) * tileSize + offset);
            }
            /*
            if(map[i] == 2){
                impassableBoxLeftSideArray[i] = new ImpassableBoxLeftSide(floorSideWidth,tileSize);
                impassableBoxRightSideArray[i] = new ImpassableBoxRightSide(floorSideWidth,tileSize);
                pc.getWorld().addObject(impassableBoxLeftSideArray[i], i % cols * tileSize,(int)Math.floor(i/cols) * tileSize + offset);
                pc.getWorld().addObject(impassableBoxRightSideArray[i], i % cols * tileSize + offset*2,(int)Math.floor(i/cols) * tileSize + offset);
            }
            */
        }
    }
}