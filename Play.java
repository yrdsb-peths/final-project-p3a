import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Actor
{
    private SimpleTimer fadeTimer;
    private boolean fadeOut = true;
    private boolean fadeIn = false;
    private GreenfootImage play;
    private int transparency;
    public Play()
    {
        play = new GreenfootImage("PressToPlay.png");
        play.scale(384*2, 192*2);
        setImage(play);
        transparency = 255;
        fadeTimer = new SimpleTimer();
    }
    public void act()
    {
        if (fadeTimer.millisElapsed() >= 100)
        {
            if (fadeOut)
            {
                transparency -= 51;
                if (play.getTransparency() <= 0)
                {
                    transparency = 0;
                    fadeOut = false;
                    fadeIn = true;
                }
            }
            else if (fadeIn)
            {
                transparency += 51;
                if (play.getTransparency() >= 255)
                {
                    transparency = 255;
                    fadeOut = true;
                    fadeIn = false;
                }
            }
            fadeTimer.mark();
            play.setTransparency(transparency);
        }
    }
}
