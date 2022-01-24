import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Scores here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scores extends World
{
    private static ArrayList<Integer> scores = new ArrayList<Integer>();
    public Scores()
    {    
        super(384*3, 192*3, 1); 
        GreenfootImage bg = new GreenfootImage("Scores.png");
        bg.scale(384*3, 192*3);
        setBackground(bg);
    }
    public static void registerScore(int score)
    {
        scores.add(score);
        Utilities.mergeSort(scores);
    }
}
