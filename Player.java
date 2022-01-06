import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int GRAVITY = 10;
    private int MAX_VERT_VELOCITY = 100;
    private int JUMP_HEIGHT = 80;
    private int vertSpeed;
    private int maxHoriVelocity = 10;
    private int horiSpeed = 5; //possible to change to make player move faster, possible powerup
    private int tempHoriSpeed;
    private int x;
    private int y;
    public Player(){
        setImage("trainer(initial).png");
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void leftRight(boolean isLeft){
        tempHoriSpeed = horiSpeed;
        if (isLeft == true){
            if (tempHoriSpeed != maxHoriVelocity){
                tempHoriSpeed = horiSpeed + 1;
            }
            
            
        } else {
            x += horiSpeed;
        }
    }
    public void jump(int y){
        
    }
    public void act()
    {
        
    }
}
