import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreCount here.
 * 
 * @author Isaac, Kenneth
 * @version 1
 */
public class ScoreCount extends Actor
{
    private Player pc;
    GreenfootImage score;
    // Handles score count display on top right of all worlds
    public ScoreCount(Player pc)
    {
        this.pc = pc;
        score = new GreenfootImage(144, 50);
        setImage(score);
        Font font = new Font("Agency FB", 30);
        score.setFont(font);
        score.setColor(Color.WHITE);
    }
    public void updateScore()
    {
        score.clear(); // used to prevent overlapping label
        score.drawString(Integer.toString(pc.score), 72, 25); // draw onto screen
        setImage(score);
    }
    public void act()
    {
        updateScore(); // if the score increases, this will update it
    }
}
