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
        Label topScore = new Label(0, 50);
        Label secondScore = new Label(0, 50);
        Label thirdScore = new Label(0, 50);
        Label fourthScore = new Label(0, 50);
        Label fifthScore = new Label(0, 50);
        Label sixthScore = new Label(0, 50);
        Label seventhScore = new Label(0, 50);
        Label eighthScore = new Label(0, 50);
        addObject(topScore, 7*24, 10*24);
        addObject(secondScore, 7*24, 13*24);
        addObject(thirdScore, 7*24, 16*24);
        addObject(fourthScore, 7*24, 19*24);
        addObject(fifthScore, 27*24, 10*24);
        addObject(sixthScore, 27*24, 13*24);
        addObject(seventhScore, 27*24, 16*24);
        addObject(eighthScore, 27*24, 19*24);
        GreenfootImage bg = new GreenfootImage("Scores.png");
        bg.scale(384*3, 192*3);
        setBackground(bg);
        for (int i = 0; i < scores.size(); i++)
        {
            System.out.println(scores.get(i));
        }
        for (int i = 1; i <= 8; i++)
        {
            String scoreDisplayed = "";
            if ((scores.size()-i) < 0)
            {
                scoreDisplayed = "-------";
            }
            else
            {
                scoreDisplayed = Integer.toString((scores.get(scores.size()-i)));
            }
            if (i == 1)
            {
                topScore.setValue("1. " + scoreDisplayed);
            }
            else if (i == 2)
            {
                secondScore.setValue("2. " + scoreDisplayed);
            }
            else if (i == 3)
            {
                thirdScore.setValue("3. " + scoreDisplayed);
            }
            else if (i == 4)
            {
                fourthScore.setValue("4. " + scoreDisplayed);
            }
            else if (i == 5)
            {
                fifthScore.setValue("5. " + scoreDisplayed);
            }
            else if (i == 6)
            {
                sixthScore.setValue("6. " + scoreDisplayed);
            }
            else if (i == 7)
            {
                seventhScore.setValue("7. " + scoreDisplayed);
            }
            else if (i == 8)
            {
                eighthScore.setValue("8. " + scoreDisplayed);
            }
        }
    }
    public static void registerScore(int score)
    {
        scores.add(score);
        Utilities.mergeSort(scores);
    }
    public void act()
    {
    }
}
