import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private double GRAVITY = 0.1; // gravity speed
    private int MAX_VERT_VELOCITY = 25;
    private double jumpSpeed = 8.0; // jump speed
    private double tempJumpSpeed = 8.0; // jump speed - decel
    private double jumpDecel = 0.75;
    private double jumpDecelTimer = 0;
    private int JUMP_HEIGHT = 100;
    private double amountFallen = 0;
    private int maxHoriVelocity = 2;
    private int horiSpeed = 1; //possible to change to make player move faster, possible powerup
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
    // Animation arrays probably could be simplified further
    private int frame = 0; // Current animation frame
    private int frameDir = 0; // Direction of animation, right = 0, left = 1
    private int lastFrameDir = 0; // Direction of last animation played
    private int frameInterval = 0; // Time waited for animation
    private int frameDelay = 10; // Time to wait for next animation
    private boolean ignoreCD = false; // Ignore animation cooldown
    private boolean forceIdle = false;
    private String lastMove = "none";
    private GreenfootImage[][] idle = new GreenfootImage[2][4];
    private GreenfootImage[][] walk = new GreenfootImage[2][6];
    private GreenfootImage[][] jump = new GreenfootImage[2][2];
    private GreenfootImage[][] fall = new GreenfootImage[2][2];
    public Player()
    {
        // Idles left and right:
        for(int i = 0; i <= 1; i++) // Right = 0, Left = 1
        {
           for(int j = 0; j <= 3; j++) // 4 idle states
            {
                idle[i][j] = new GreenfootImage("PCAnim/adventurer-idle-0" + j + "-" + i + ".png");
                idle[i][j].scale((int)(24*1.6), (int)(30*1.6));
            }
        }
        // Walk left and right:
        for(int i = 0; i <= 1; i++)
        {
            for(int j = 0; j <= 5; j++)
            {
                walk[i][j] = new GreenfootImage("PCAnim/adventurer-run-0" + j + "-" + i + ".png");
                walk[i][j].scale((int)(24*1.6), (int)(30*1.6));
            }
        }
        // Jump left and right:
        for(int i = 0; i <= 1; i++)
        {
            for(int j = 0; j <= 1; j++)
            {
                jump[i][j] = new GreenfootImage("PCAnim/adventurer-jump-0" + j + "-" + i + ".png");
                jump[i][j].scale((int)(24*1.6), (int)(30*1.6));
            }
        }
        // Fall left and right:
        for(int i = 0; i <= 1; i++)
        {
            for(int j = 0; j <= 1; j++)
            {
                fall[i][j] = new GreenfootImage("PCAnim/adventurer-fall-0" + j + "-" + i + ".png");
                fall[i][j].scale((int)(24*1.6), (int)(30*1.6));
            }
        }
        setImage(idle[0][0]);
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
        if(Greenfoot.isKeyDown("w") && !isFalling){
            wPressed = true;
        }
        if(Greenfoot.isKeyDown("a")){
            aPressed = true;
            changeFrameDir(1); // now facing left
        } else {
            aPressed = false;
        }
        if(Greenfoot.isKeyDown("d")){
            dPressed = true;
            changeFrameDir(0); // now facing right
        } else {
            dPressed = false;
        }
        if(wPressed){
            if (!isJumping){
                amountJumped = 0;
                tempJumpSpeed = jumpSpeed;
                isJumping = true;
            } else if (!isFalling){
                if (tempJumpSpeed <= 0){
                    isFalling = true;
                    amountFallen = 0;
                    amountJumped = 0;
                    wPressed = false;
                    jumpDecelTimer = 0;
                } else {
                    y -= tempJumpSpeed;
                    amountJumped += tempJumpSpeed;
                    if (jumpDecelTimer % 2 == 0)
                    {
                        tempJumpSpeed -= jumpDecel;
                    }
                    jumpDecelTimer += 1;
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
    // Refine code
    private void animationState()
    {
        if(lastFrameDir != frameDir)
        {
            if (!(aPressed && dPressed))
            {
                ignoreCD = true;
            }
            else
            {
                forceIdle = true;
            }
        }
        if(isFalling)
        {
            if (!lastMove.equals("fall"))
            {
                frame = 0;
                ignoreCD = true;
            }
            if (frameInterval % frameDelay == 0 || ignoreCD)
            {
                frame = (frame + 1) % fall[0].length;
                setImage(fall[frameDir][frame]);
                lastMove = "fall";
            }
        }
        else if(isJumping)
        {
            if (!lastMove.equals("jump"))
            {
                frame = 0;
                ignoreCD = true;
            }
            if (frameInterval % frameDelay == 0 || ignoreCD)
            {
                frame = (frame + 1) % jump[0].length;
                setImage(jump[frameDir][frame]);
                lastMove = "jump";
            }
        }
        else if((dPressed || aPressed) && !forceIdle)
        {
            if (!lastMove.equals("walk"))
            {
                frame = 0;
                ignoreCD = true;
            }
            if (frameInterval % frameDelay == 0 || ignoreCD)
            {
                frame = (frame + 1) % walk[0].length;
                setImage(walk[frameDir][frame]);
                lastMove = "walk";
            }
        }
        else
        {
            if (!lastMove.equals("idle"))
            {
                frame = 0;
                ignoreCD = true;
            }
            if (frameInterval % frameDelay == 0 || ignoreCD)
            {
                frame = (frame + 1) % idle[0].length;
                setImage(idle[frameDir][frame]);
                lastMove = "idle";
                lastFrameDir = frameDir;
            }
        }
        if (frameInterval >= 100){frameInterval = 0;}
        frameInterval++;
        ignoreCD = false;
        forceIdle = false;
    }
    private void changeFrameDir(int newDir)
    {
        lastFrameDir = frameDir;
        frameDir = newDir;
    }
    public void act(){
        animationState();
        movement();
    }
}
