import java.util.*;
import java.io.*;
/**
 * Reads the a text file based off of parameter, puts the contents of text file
 * into an array
 * 
 * @author Isaac, Kenneth
 * @version 1
 */
public class MapReader
{
    public static int[] fromFile(String levelMap){
        int [] map = new int [1152];
        try {
            File mapFile = new File(levelMap);
            Scanner scanner = new Scanner(mapFile);
            for(int i = 0; i < map.length; i++){
                map[i] = scanner.nextInt();
            }
        } catch (Exception e) {
              
        } 
        return map;
    }
}
