import greenfoot.GreenfootSound;
/**
 * Write a description of class Sounds here.
 * 
 * @author Isaac, Kenneth 
 * @version 1
 */
public class Sounds  
{
    private static GreenfootSound backgroundMusic = new GreenfootSound("BGM.wav");
    private static GreenfootSound loseMusic = new GreenfootSound("Lose.wav");
    private static GreenfootSound winMusic = new GreenfootSound("Win.wav");
    
    // Play a sound
    public static void playSound(String fileName)
    {
        GreenfootSound soundPlayed = new GreenfootSound(fileName);
        soundPlayed.setVolume(40);
        soundPlayed.play();
    }
    // Set the BGM on a loop
    public static void setBGM(String fileName)
    {
        if (fileName.equals("BGM.mp3"))
        {
            backgroundMusic.setVolume(28);
            backgroundMusic.playLoop();
        }
        else if (fileName.equals("Lose.mp3"))
        {
            loseMusic.setVolume(25);
            loseMusic.playLoop();
        }
        else if (fileName.equals("Win.mp3"))
        {
            winMusic.setVolume(25);
            winMusic.playLoop();
        }
    }
    // stop the bgm
    public static void stopBGM(String fileName)
    {
        if (fileName.equals("BGM.mp3"))
        {
            backgroundMusic.pause(); // pause is used here due to Greenfoot limitations
            // Stop seems to work for other sound files, if not change it to pause
        }
        else if (fileName.equals("Lose.mp3"))
        {
            loseMusic.stop();
        }
        else if (fileName.equals("Win.mp3"))
        {
            winMusic.stop();
        }
    }
}
