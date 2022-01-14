import java.util.*;
import java.io.*;
/**
 * Write a description of class Scanner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MapReader
{
    public static int[] fromFile(String levelMap){
        int [] map = new int [1152];
        try {
            File mapFile = new File(levelMap);
            Scanner scanner = new Scanner(mapFile);
            int arrMax = 0;
            for(int i = 0; i < map.length; i++){
                map[i] = scanner.nextInt();
            }
        } catch (Exception e) {
              
        } 
        return map;
    }
}

