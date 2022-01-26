import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HitboxVisualizer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HitboxVisualizer extends Actor
{
    // A class that handles the collision of player with collectables and spikes
    // Implemented to make the hitbox more forgiving
    private Player pc;
    public HitboxVisualizer(Player pc)
    {
        this.pc = pc;
        GreenfootImage boundingBox = new GreenfootImage((int)(24*1.18), (int)(30*1.38));
        setImage(boundingBox);
        
        boundingBox.setColor(new Color(128, 128, 128));
        boundingBox.setTransparency(80);
        boundingBox.fill();
    }
    private void checkCollision()
    {
        if(isTouching(Heart.class))
        {
            Sounds.playSound("GetHeart.mp3");
            pc.updateHP(true);
            Heart touched = (Heart)getOneIntersectingObject(Heart.class);
            getWorld().removeObject(touched);
        }
        else if(isTouching(Spike.class))
        {
            Sounds.playSound("PlayerHit.mp3");
            pc.updateHP(false);
            pc.setLocation(pc.spawn[0], pc.spawn[1] - 24);
        }
        else if(isTouching(Chest.class))
        {
            Sounds.playSound("GetChest.mp3");
            pc.updateScore("Chest");
            Chest touched = (Chest)getOneIntersectingObject(Chest.class);
            getWorld().removeObject(touched);
        }
        else if(isTouching(Coin.class))
        {
            Sounds.playSound("GetCoin.mp3");
            pc.updateScore("Coin");
            Coin touched = (Coin)getOneIntersectingObject(Coin.class);
            getWorld().removeObject(touched);
        }
    }
    public void act()
    {
        setLocation(pc.getX(), pc.getY()-1); // Always follows player with slight y-value offset
        checkCollision(); // Check to see if touching something
    }
}
