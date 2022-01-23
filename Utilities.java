/**
 * Write a description of class Utilities here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Utilities  
{
    public static void drawHP(Player pc)
    {
        for(int i = 0; i < Player.lives.length; i++)
        {
            pc.getWorld().addObject(Player.lives[i], (384*3 - (Lives.resizeX/2)) - (Lives.resizeX*i), 
                0 + (Lives.resizeY/2));
        }
    }
    public static void drawScore(Player pc)
    {
        pc.getWorld().addObject(new ScoreCount(pc), 384*3 - ((144/5)*2), 68);
    }
}
