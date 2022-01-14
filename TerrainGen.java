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
    private static ImpassableBox[] impassableBoxArray = new ImpassableBox[1152];
    private int tileSize = 24; // Tiles are 24 x 24 pixels
    private int cols = 48; // The map is 48 tiles wide
    private int offset = tileSize/2; // Greenfoot drawing offset
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
                impassableBoxArray[i] = new ImpassableBox (tileSize,tileSize);
                pc.getWorld().addObject(impassableBoxArray[i], i % cols * tileSize + offset ,(int)Math.floor(i/cols) * tileSize + offset);
            }
        }
    }
}
