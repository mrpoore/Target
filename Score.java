package Target;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Maintains and displays the player's score.
 * 
 * @author Michael Berry
 * @version 29/05/08
 */
public class Score extends Actor
{

    private int score;

    /**
     * Called when the score is first added. Sets to 0.
     */
    public void addedToWorld(World world)
    {
        score = 0;
        addScore(0);
    }
    
    /**
     * Adds a value to the score.
     * @num the value to add to the score.
     */
    public void addScore(int num)
    {
        score += num;
        GreenfootImage image = new GreenfootImage(100, 25);
        image.drawString("Score: " + score, 20, 20);
        setImage(image);
    }
    
    /**
     * Gets the value of this score.
     * @return how many points the player has.
     */
    public int getScore()
    {
        return score;
    }
}
