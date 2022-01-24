import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HitboxVisualizer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HitboxVisualizer extends Actor
{
    private Player pc;
    public HitboxVisualizer(Player pc)
    {
        this.pc = pc;
        GreenfootImage boundingBox = new GreenfootImage((int)(24*1.18), (int)(30*1.5));
        setImage(boundingBox);
        
        boundingBox.setColor(new Color(128, 128, 128));
        boundingBox.setTransparency(80);
        boundingBox.fill();
    }
    private void checkCollision()
    {
        if(isTouching(Heart.class))
        {
            pc.updateHP(true);
            Heart touched = (Heart)getOneIntersectingObject(Heart.class);
            getWorld().removeObject(touched);
        }
        else if(isTouching(Spike.class))
        {
            pc.updateHP(false);
            pc.setLocation(pc.spawn[0], pc.spawn[1] - 24);
        }
        else if(isTouching(Chest.class))
        {
            pc.updateScore("Chest");
            Chest touched = (Chest)getOneIntersectingObject(Chest.class);
            getWorld().removeObject(touched);
        }
        else if(isTouching(Coin.class))
        {
            pc.updateScore("Coin");
            Coin touched = (Coin)getOneIntersectingObject(Coin.class);
            getWorld().removeObject(touched);
        }
    }
    public void act()
    {
        setLocation(pc.getX(), pc.getY()-2);
        checkCollision();
    }
}
