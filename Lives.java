import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lives here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Lives extends Actor
{
     private boolean filled;
     private GreenfootImage filledContainer;
     private GreenfootImage unfilledContainer;
     public static final int resizeX = 24*2;
     public static final int resizeY = 25*2;
     // Class that handles the display of the player's health
     // Also doubles to manage player's health
     public Lives(boolean filled)
     {
         this.filled = filled;
         filledContainer = new GreenfootImage("Collectables/Heart.png");
         filledContainer.scale(resizeX, resizeY);
         unfilledContainer = new GreenfootImage("HPContainer.png");
         unfilledContainer.scale(resizeX, resizeY);
         if (filled)
         {
             setImage(filledContainer);
         }
         else
         {
             setImage(unfilledContainer);
         }
     }
     public boolean getFilled()
     {
         return filled;
     }
     public void updateStatus(boolean filled)
     {
         if (filled)
         {
             setImage(filledContainer);
         }
         else
         {
             setImage(unfilledContainer);
         }
         this.filled = filled;
     }
}
