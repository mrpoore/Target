import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

/**
 * The world where everything goes.
 * 
 * @author Michael Berry
 * @version 29/05/08
 */
public class TargetWorld extends World
{

    private Score score;
    private Arrows arrows;
    
    /**
     * Creates a new TargetWorld. Places the counters, man and target.
     */
    public TargetWorld()
    {    
        super(1000, 500, 1);
        score = new Score();
        addObject(score, 900, 10);
        
        arrows = new Arrows();
        addObject(arrows, 800, 10);
        
        addObject(new Man(), 136, 395);
        
        addObject(new Target(), getWidth()-50, getHeight()/2);
    }
    
    /**
     * Return the number of arrows left.
     * @return number of arrows left.
     */
    public int getArrows()
    {
        return arrows.getNum();
    }
    
    /**
     * Add arrows.
     * @num the number of arrows to add.
     */
    public void addArrows(int num)
    {
        arrows.add(num);
    }
    
    /**
     * Add something to the player's score.
     * @num the number to add to the score.
     */
    public void addScore(int num)
    {
        score.addScore(num);
    }
    
    /**
     * Called when there are no more arrows left.
     */
    public void gameOver()
    {
        if(getArrows()<=0){
            JOptionPane.showMessageDialog(null, "Game over!\nScore: " + score.getScore());
            //Greenfoot.stopSimulation();
        }
    }
}
