import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Manages display of player health and manages player health
 * 
 * @author Isaac, Kenneth
 * @version 1
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
     // check if it the life is filled
     public boolean getFilled()
     {
         return filled;
     }
     // Update the status of the lives image
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
