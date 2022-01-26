import greenfoot.*;
/**
 * Generates the map with walls, collectables and dangers based off a text file
 * 
 * @author Isaac, Kenneth
 * @version 1
 */
public class TerrainGen extends Actor 
{
    // Array to hold the possible locations (tiles) of a collidable actor
    // There are 1152 possible locations, 48 tiles x 24 tiles
    // Make a new array for each possible collidable actor as they can be in any
    // Position of the 1152 tiles
    private static ImpassableBoxLeftSide impassableBoxLeftSideArray[] = new ImpassableBoxLeftSide[1152];
    private static ImpassableBoxRightSide impassableBoxRightSideArray[] = new ImpassableBoxRightSide[1152];
    private static ImpassableBoxFloor impassableBoxFloorArray[] = new ImpassableBoxFloor[1152];
    private static ImpassableBoxCeiling impassableBoxCeilingArray[] = new ImpassableBoxCeiling[1152];
    private static EmptyVoid emptyVoidArray[] = new EmptyVoid[1152];
    private static NextLevel nextLevelArray[] = new NextLevel[1152];
    private static Heart[] heartArr = new Heart[1152];
    private static Chest[] chestArr = new Chest[1152];
    private static Coin[] coinArr = new Coin[1152];
    private static Spike[] spikeArr = new Spike[1152];
    private int tileSize = 24; // Tiles are 24 x 24 pixels
    private int drawnTileSize = 20; //Drawn tiles are 20 x 20 pixels to prevent overlapping tiles
    //Platforms are 12 x 11 pixels, filled in to prevent falling through the platform
    private int platformTileSize = 12;
    private int platformTileWidth = 11;
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
    /*
     * Creates a map based on the .txt file used in above constructor
     * Takes Player Actor as parameter to determine world
     */
    public void createMap(Player pc){
        for(int i = 0; i < map.length; i++){
            if(map[i] == 1){ // Terrain/Boundaries
                impassableBoxLeftSideArray[i] = new ImpassableBoxLeftSide(floorSideWidth,drawnTileSize);
                impassableBoxRightSideArray[i] = new ImpassableBoxRightSide(floorSideWidth,drawnTileSize);
                impassableBoxCeilingArray[i] = new ImpassableBoxCeiling(drawnTileSize,floorSideWidth);
                impassableBoxFloorArray[i] = new ImpassableBoxFloor(drawnTileSize,floorSideWidth);
                pc.getWorld().addObject(impassableBoxLeftSideArray[i], i % cols * tileSize,(int)Math.floor(i/cols) * tileSize + offset);
                pc.getWorld().addObject(impassableBoxRightSideArray[i], i % cols * tileSize + offset*2,(int)Math.floor(i/cols) * tileSize + offset);
                pc.getWorld().addObject(impassableBoxFloorArray[i], i % cols * tileSize + offset,(int)Math.floor(i/cols) * tileSize);
                pc.getWorld().addObject(impassableBoxCeilingArray[i], i % cols * tileSize + offset,(int)Math.floor(i/cols) * tileSize + offset*2);
            }
            if(map[i] == 2){ // Platform collision
                impassableBoxFloorArray[i] = new ImpassableBoxFloor(platformTileSize,platformTileWidth);
                impassableBoxCeilingArray[i] = new ImpassableBoxCeiling(platformTileSize,floorSideWidth);
                pc.getWorld().addObject(impassableBoxFloorArray[i], i % cols * tileSize + offset,(int)Math.floor(i/cols) * tileSize);
                pc.getWorld().addObject(impassableBoxCeilingArray[i], i % cols * tileSize + offset,(int)Math.floor(i/cols) * tileSize + 6);
            }
            if(map[i] == 3){ // Void/ Lava
                emptyVoidArray[i] = new EmptyVoid(tileSize,floorSideWidth);
                pc.getWorld().addObject(emptyVoidArray[i], i % cols * tileSize + offset, (int)Math.floor(i/cols) * tileSize + offset);
            }
            if(map[i] == 4){ // Next level box
                nextLevelArray[i] = new NextLevel(drawnTileSize, drawnTileSize);
                pc.getWorld().addObject(nextLevelArray[i], i % cols * tileSize + offset, (int)Math.floor(i/cols) * tileSize + offset);
            }
            if(map[i] == 5){ // Hearts
                heartArr[i] = new Heart();
                pc.getWorld().addObject(heartArr[i], i % cols * tileSize + offset, (int)Math.floor(i/cols) * tileSize + offset);
            }
            if(map[i] == 6){ // Coins
                coinArr[i] = new Coin();
                pc.getWorld().addObject(coinArr[i], i % cols * tileSize + offset, (int)Math.floor(i/cols) * tileSize + offset);
            }    
            if(map[i] == 7){ // Chest; spawns on left side of a 2 tile space
                chestArr[i] = new Chest();
                pc.getWorld().addObject(chestArr[i], i % cols * tileSize + 24, (int)Math.floor(i/cols) * tileSize + (offset - 1));
            }
            if(map[i] == 8){ // Spike
                spikeArr[i] = new Spike();
                pc.getWorld().addObject(spikeArr[i], i % cols * tileSize + 12, (int)Math.floor(i/cols) * tileSize + (offset + 3));
            }
        }
    }
}