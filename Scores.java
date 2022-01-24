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
    private Label scoreLabel;
    private Label topScore;
    private Label secondScore;
    private Label thirdScore;
    private Label fourthScore;
    private Label fifthScore;
    public Scores()
    {    
        super(384*3, 192*3, 1); 
        Label scoreLabel = new Label("Highscores", 50);
        Label topScore = new Label(0, 50);
        Label secondScore = new Label(0, 50);
        Label thirdScore = new Label(0, 50);
        Label fourthScore = new Label(0, 50);
        Label fifthScore = new Label(0, 50);
        addObject(scoreLabel, getWidth()/2, getHeight()/12);
        addObject(topScore, getWidth()/2, getHeight()/6);
        addObject(secondScore, getWidth()/2, getHeight()/6*2);
        addObject(thirdScore, getWidth()/2, getHeight()/6*3);
        addObject(fourthScore, getWidth()/2, getHeight()/6*4);
        addObject(fifthScore, getWidth()/2, getHeight()/6*5);
        GreenfootImage bg = new GreenfootImage("Scores.png");
        bg.scale(384*3, 192*3);
        setBackground(bg);
    }
    public static void registerScore(int score)
    {
        scores.add(score);
        Utilities.mergeSort(scores);
    }
    public void act(){
        //System.out.println(scores.get(scores.size()-1));
        topScore.setValue(100);
        /*
        if (scores.size() > 2){
            secondScore.setValue(scores.get(scores.size()-2));
            if (scores.size() > 3){
                thirdScore.setValue(scores.get(scores.size()-3));
                if (scores.size() > 4){
                    fourthScore.setValue(scores.get(scores.size()-4));
                    if (scores.size() > 5){
                        fifthScore.setValue(scores.get(scores.size()-5));
                    }
                }
            }
        }
        */
    }
}
