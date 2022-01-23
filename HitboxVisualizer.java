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
        GreenfootImage boundingBox = new GreenfootImage((int)(24*1.2), (int)(30*1.6));
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
            Heart heartTouched = (Heart)getOneIntersectingObject(Heart.class);
            getWorld().removeObject(heartTouched);
        }
        else if(isTouching(Spike.class))
        {
            pc.updateHP(false);
            pc.setLocation(pc.spawn[0], pc.spawn[1] - 24);
        }
    }
    public void act()
    {
        setLocation(pc.getX(), pc.getY());
        checkCollision();
    }
}
