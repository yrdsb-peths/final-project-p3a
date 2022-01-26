import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Handles the player. Has player movement, collision against walls, player
 * animation, moving worlds, hp and score
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    // World variables
    private String curWorld;
    public static int[] spawn = {200, 528}; // Default is for tutorial
    // Note: First life listed here is third life slot
    public static Lives[] lives = {new Lives(true), new Lives(true), new Lives(true)};
    public static int score = 0;
    
    // Movement variables
    private double GRAVITY = 0.1; // gravity speed
    private int MAX_VERT_VELOCITY = 20;
    private double jumpSpeed = 8.0; // jump speed
    private double tempJumpSpeed = 8.0; // jump speed - decel
    private double jumpDecel = 0.75;
    private double jumpDecelTimer = 0;
    private int JUMP_HEIGHT = 100;
    private double amountJumped;
    private double amountFallen = 0;
    private int maxHoriVelocity = 2;
    private int horiSpeed = 1; //possible to change to make player move faster, possible powerup
    private double tempHoriSpeed;
    private int x;
    private int y;
    private boolean wPressed;
    private boolean aPressed;
    private boolean dPressed;
    private boolean isFalling = false;
    private boolean isJumping = false;
    private char lastMoveState;
    
    // Animation variables
    private int frame = 0; // Current animation frame
    private int frameDir = 0; // Direction of animation, right = 0, left = 1
    private int lastFrameDir = 0; // Direction of last animation played
    private int frameInterval = 0; // Time waited for animation
    private int frameDelay = 10; // Time to wait for next animation
    private boolean ignoreCD = false; // Ignore animation cooldown
    private boolean forceIdle = false; // Force into idle animation
    private String lastMove = "none"; // Last movement animation
    private GreenfootImage[][] idle = new GreenfootImage[2][4];
    private GreenfootImage[][] walk = new GreenfootImage[2][6];
    private GreenfootImage[][] jump = new GreenfootImage[2][4];
    private GreenfootImage[][] fall = new GreenfootImage[2][2];
    
    public Player(String curWorld)
    {
        this.curWorld = curWorld;
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
            for(int j = 0; j <= 3; j++)
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
    //moves the player based on any x,y changes given by movement
    private void move(int x,int y){
        setLocation(getX()+x, getY()+y);
    }
    
    //handles the left and right movement
    private void leftRight(boolean aPressed, boolean dPressed){
        //slowly increases speed as you hold 'A' or 'D'
        if (tempHoriSpeed <= maxHoriVelocity){
            tempHoriSpeed += 0.1;
        }
        //if 'A' and 'D' are pressed at the same time, reset speed
        if (aPressed && dPressed){
            tempHoriSpeed = horiSpeed;
        } else {
            //if 'A' pressed, subtract from x value
            if(aPressed){
                if(isTouching(ImpassableBoxRightSide.class)){
                    
                } else {
                    x -= tempHoriSpeed;
                }
            }
            //if 'D' pressed, add to x value
            if(dPressed){
                if(isTouching(ImpassableBoxLeftSide.class)){
                    
                } else {
                    x += tempHoriSpeed;
                }
            }
        }
    }
    
    private void jump(){ 
        if (!isJumping){
            amountJumped = 0;
            tempJumpSpeed = jumpSpeed;
            isJumping = true;           
        } else if (!isFalling){
            if (tempJumpSpeed <= 0){           
                isFalling = true;
                isJumping = false;              
                amountFallen = 0;
                amountJumped = 0;
                wPressed = false;
                jumpDecelTimer = 0;
            } else {    
                y -= tempJumpSpeed;
                amountJumped += tempJumpSpeed;
                if (isTouching(ImpassableBoxCeiling.class))
                {
                    tempJumpSpeed = 0;
                }
                else if (jumpDecelTimer % 2 == 0)
                {
                    tempJumpSpeed -= jumpDecel;
                }
                jumpDecelTimer += 1;
            }
        } else if (wPressed == false && isJumping == true && isFalling == false){
            isFalling = true;
            amountFallen = 0;
            amountJumped = 0;
        }
    }
    
    //handles the player falling 
    private void fall(){
        //slowly ramps up how fast they fall
        if ((amountFallen += GRAVITY) != MAX_VERT_VELOCITY){
            amountFallen = (amountFallen + GRAVITY);
        }
        
        y += amountFallen;
    }
    
    //handles movement and collision
    private void movementCollision()
    {
        //resets x,y changes 
        x= 0;
        y= 0;
        
        //detects which keys are pressed
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
            jump();
        }
        
        //calls leftRight method to move player left or right 
        if(aPressed == true || dPressed == true){
            leftRight(aPressed, dPressed);
        }else{
            //resets the velocity if neither 'A' or 'D' is pressed
            tempHoriSpeed = horiSpeed;
        }
        
        //pushes player out of ground incase they clip into the floor
        if (isTouching(ImpassableBoxFloor.class) && (isTouching(ImpassableBoxLeftSide.class) || isTouching(ImpassableBoxRightSide.class))){
            y-= 1;
        }
        
        //will make you fall if you are in the air and not jumping
        if (!(isTouching(ImpassableBoxFloor.class)) && isJumping == false && !(isTouching(ImpassableBoxLeftSide.class) || isTouching(ImpassableBoxRightSide.class)) && isFalling == false){
            amountFallen = 0;
            isFalling = true;
        }
        
        if (isFalling == true){
            fall();
        }
               
        move(x,y);
        
        //resets jump if touching the floor
        if (!isTouching(ImpassableBoxCeiling.class)){
            if (isTouching(ImpassableBoxFloor.class) && isFalling == true){
                isJumping = false;
                isFalling = false;
            }
        }
        
        //incase player is stuck inbetween a ceiling and floor, it will 
        //push the player out
        if (isTouching(ImpassableBoxCeiling.class) && isTouching(ImpassableBoxFloor.class)){
            y += 1;
        }
        
        //resets position of player and takes one life from the player
        if(isTouching(EmptyVoid.class)){
            y = 0; // Reset velocities
            x = 0;
            Sounds.playSound("Void.mp3");
            updateHP(false);
            setLocation(spawn[0], spawn[1] - 24); // Reset to spawn; -24 offset on y to prevent clipping
        }
        
        //makes you lose if you run out of lives
        if(!lives[lives.length-1].getFilled())
        {
            Lose gameWorld = new Lose();
            Greenfoot.setWorld(gameWorld);
        }
        
        //sends you to next world
        if(isTouching(NextLevel.class)){
            nextWorld(curWorld);
        }
    }
    
    //handles all the world changing
    public void nextWorld(String curWorld){
        // If the Player object is touching any object of the NextLevelBox class
        if(isTouching(NextLevel.class)){
            Sounds.playSound("NextLevel.mp3");
            if(curWorld.equals("Tutorial")){ // If on tutorial
                spawn[0] = 48; // Sets spawn x
                spawn[1] = 504; // Sets spawn y
                LevelOne gameWorld = new LevelOne();
                Greenfoot.setWorld(gameWorld); // Go to level one
            }else if(curWorld.equals("LevelOne")){ // If on level one
                spawn[0] = 100;
                spawn[1] = 100;
                LevelTwo gameWorld= new LevelTwo();
                Greenfoot.setWorld(gameWorld); // Go to level two
            }else if (curWorld.equals("LevelTwo")){ // If on level two
                spawn[0] = 48;
                spawn[1] = 312;
                LevelThree gameWorld= new LevelThree();
                Greenfoot.setWorld(gameWorld); // Go to level one
            } else if (curWorld.equals("LevelThree")){
                spawn[0] = 48;
                spawn[1] = 240;
                LevelFour gameWorld = new LevelFour();
                Greenfoot.setWorld(gameWorld); // Go to level four
            } else if (curWorld.equals("LevelFour"))
            {
                Win gameWorld = new Win();
                Greenfoot.setWorld(gameWorld); // Go to win screen
            }
        }
    }
    
    
    private void animationState()
    {
        // If moving left previously, but now moving right
        if(lastFrameDir != frameDir)
        {
            if (!(aPressed && dPressed)) // Both a and d are not pressed
            {
                ignoreCD = true;
            }
            else
            {
                forceIdle = true;
            }
        }
        if(isFalling) // Falling
        {
            if (!lastMove.equals("fall")) // Previously not falling
            {
                frame = 0; // Reset frame count
                ignoreCD = true; // Skip animation delay
            }
            if (frameInterval % frameDelay == 0 || ignoreCD)
            {
                frame = (frame + 1) % fall[0].length; // add frames on to animate
                setImage(fall[frameDir][frame]); // set to frame
                lastMove = "fall"; // last movement vector was fall
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
        else // Player is idle
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
                lastFrameDir = frameDir; // reset movement directions
            }
        }
        // To avoid integer overflow, reset frameInterval
        if (frameInterval >= 100){frameInterval = 0;} 
        frameInterval++;
        ignoreCD = false;
        forceIdle = false;
    }
    public void updateHP(boolean heal) // if false, damage
    {
        if (lives[0].getFilled() && heal) // has max HP and healing
        {
            score += 300; // Increase score
        }
        else // Not max hp or not healing
        {
            for (int i = 0; i < lives.length; i++)
            {
                if (lives[i].getFilled() && !heal) // Has HP here and taking dmg
                {
                    lives[i].updateStatus(false); // Take damage
                    break;
                }
            }
            for (int i = 2; i >= 0; i--)
            {
                if (!lives[i].getFilled() && heal) // No HP here and healing
                {
                    lives[i].updateStatus(true); // heal
                    break;
                }
            }
        }
    }
    // Called when chest or coin is touched, increases score
    public void updateScore(String collected)
    {
        if (collected.equals("Chest"))
        {
            score += 500;
        }
        else if (collected.equals("Coin"))
        {
            score += 100;
        }
    }
    // Used to manage last movement direction vs. current movement direction
    private void changeFrameDir(int newDir)
    {
        lastFrameDir = frameDir;
        frameDir = newDir;
    }
    
    public void act(){
        animationState();
        movementCollision();
    }
}
