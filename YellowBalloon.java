import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A yellow balloon. Adds 1 to the player's score and gives 10 arrows.
 * 
 * @author Michael Berry
 * @version 29/05/08
 */
public class YellowBalloon extends Balloon
{
    /**
     * Adds 1 to the score and gives 10 arrows when hit.
     */
    public void act() 
    {
        super.act(1, 10);
    }    
}
