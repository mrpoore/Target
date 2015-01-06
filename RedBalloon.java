package Target;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A red balloon. Adds 50 to the player's score.
 * 
 * @author Michael Berry
 * @version 29/05/08
 */
public class RedBalloon extends Balloon
{
    /**
     * Adds 50 to the score on a hit.
     */
    public void act() 
    {
        super.act(50, 0);
    }    
}
