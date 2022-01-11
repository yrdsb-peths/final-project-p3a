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
    private double amountJumped;
    private double tempHoriSpeed;
    private boolean wPressed;
    private boolean aPressed;
    private boolean dPressed;
    private boolean isFalling = false;
    private boolean isJumping = false;
    private char lastMoveState;
    public Player(){
        setImage("adventurer-idle-00.png");
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private void move(int x,int y){
        setLocation(getX()+x, getY()+y);
    }
    private void leftRight(boolean aPressed, boolean dPressed){
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
    private void fall(){
        if ((amountFallen += GRAVITY) != MAX_VERT_VELOCITY){
            amountFallen = (amountFallen + GRAVITY);
        }
        y += amountFallen;
    }
    private void movement()
    {
        x= 0;
        y= 0;
        animationState();
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
            if (isJumping == false){
                amountJumped = 0;
                isJumping = true;
            } else if (isFalling == false){
                if (amountJumped >= JUMP_HEIGHT){
                    isFalling = true;
                    amountFallen = 0;
                    amountJumped = 0;
                } else {
                    y -= 10;
                    amountJumped += 10;
                }
            }
        } else if (wPressed == false && isJumping == true && isFalling == false){
            isFalling = true;
            amountFallen = 0;
            amountJumped = 0;
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
            isJumping = false;
            isFalling = false;
        }
    }
    // To do: Fix fall state, add dynamic animations
    // Possibly resize image slightly?
    private void animationState()
    {
        // Check state left, right
        if (Greenfoot.isKeyDown("d"))
        {
            //state right
            lastMoveState = 'R';
            setImage("adventurer-run-01.png");
        }
        else if (Greenfoot.isKeyDown("a"))
        {
            //state left
            lastMoveState = 'L';
            setImage("adventurer-run-01(L).png");
        }
        else if (isJumping)
        {
            switch(lastMoveState)
            {
                case 'R': setImage("adventurer-jump-02.png");
                    break;
                case 'L': setImage("adventurer-jump-02(L).png");
                    break;
            }
        }
        else if (isFalling)
        {
            switch(lastMoveState)
            {
                case 'R': setImage("adventurer-fall-00.png");
                    break;
                case 'L': setImage("adventurer-fall-00(L).png");
                    break;
            }
        }
        else
        {
            switch(lastMoveState)
            {
                case 'R': setImage("adventurer-idle-00.png");
                    break;
                case 'L': setImage("adventurer-idle-00(L).png");
                    break;
            }
        }
    }
    public void act(){
        movement();
    }
}
