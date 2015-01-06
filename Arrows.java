import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Maintains and displays the number of arrows the player has.
 * 
 * @author Michael Berry
 * @version 29/05/08
 */
public class Arrows extends Actor
{

    private int arrows;
    /** The maximum number of arrows the player can hold. */
    public final int MAX = 100;

    /**
     * Sets up the player with 50 arrows initially.
     */
    public void addedToWorld(World world)
    {
        arrows = 50;
        add(0);
    }
    
    /**
     * Add arrows. If the number of arrows exceeds the maximum allowed, don't add any more.
     */
    public void add(int num)
    {
        arrows += num;
        if(arrows>MAX) arrows = MAX;
        GreenfootImage image = new GreenfootImage(120, 25);
        image.drawString("Arrows: " + arrows, 20, 20);
        setImage(image);
    }
    
    /**
     * Return the number of arrows.
     */
    public int getNum()
    {
        return arrows;
    }
}
