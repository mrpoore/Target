package Target;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A blue balloon. Adds 20 to the player's score.
 * 
 * @author Michael Berry
 * @version 29/05/08
 */
public class BlueBalloon extends Balloon
{

    /**
     * Adds 20 to the player's score when hit.
     */
    public void act() 
    {
        super.act(20, 0);
    }    
}
