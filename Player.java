import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private double GRAVITY = 0.1;
    private int MAX_VERT_VELOCITY = 50;
    private int JUMP_HEIGHT = 100;
    private double amountFallen = 0;
    private int maxHoriVelocity = 8;
    private int horiSpeed = 2; //possible to change to make player move faster, possible powerup
    private int x;
    private int y;
    private int floor = 200;
    private double tempHoriSpeed;
    private boolean wPressed;
    private boolean aPressed;
    private boolean dPressed;
    private boolean isFalling = false;
    public Player(){
        setImage("trainer(initial).png");
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void move(int x,int y){
        setLocation(getX()+x, getY()+y);
    }
    public void leftRight(boolean aPressed, boolean dPressed){
        if (tempHoriSpeed <= maxHoriVelocity){
            tempHoriSpeed += 0.1;
        }
        if (aPressed == true && dPressed == true){
            tempHoriSpeed = horiSpeed;
        } else {
            if(aPressed == true){
                x -= tempHoriSpeed;
            }
            if(dPressed == true){
                x += tempHoriSpeed;
            }
        }
    }
    public void fall(){
        if ((amountFallen += GRAVITY) != MAX_VERT_VELOCITY){
            amountFallen = (amountFallen + GRAVITY);
        }
        y += amountFallen;
    }
    public void movement()
    {
        x= 0;
        y= 0;
        if(Greenfoot.isKeyDown("w")){
            wPressed = true;
        } else {
            wPressed = false;
        }
        if(Greenfoot.isKeyDown("a")){
            aPressed = true;
        } else {
            aPressed = false;
        }
        if(Greenfoot.isKeyDown("d")){
            dPressed = true;
        } else {
            dPressed = false;
        }
        
        if(wPressed == true){
            if(isFalling == false){
                y -= JUMP_HEIGHT;
                isFalling = true;
                amountFallen = 0;
            }
        }
        if(aPressed == true || dPressed == true){
            leftRight(aPressed, dPressed);
        }else{
            tempHoriSpeed = horiSpeed;
        }
        if (isFalling == true){
            fall();
        }
        move(x,y);
        if (getY() >= floor && isFalling == true){
            isFalling = false;
        }
    }
    public void act(){
        movement();
    }
}
