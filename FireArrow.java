import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An arrow that is fired by the Man.
 * 
 * @author your-name-here
 * @version date-here
 */
public class FireArrow extends Actor
{

    private Vector force;
    private int life = 500;
    private boolean last = false;
    private boolean latch = false;
    private TargetWorld world;
    
    /**
     * Called when the arrow is added to the world.
     */
    public void addedToWorld(World world)
    {
        this.world = (TargetWorld)world;
    }

    /**
     * Create a new firearrow with a certain force.
     */
    public FireArrow(Vector force)
    {
        this.force = force;
    }
    
    /**
     * Control the arrow's movement. Delete the arrow if it goes off screen.
     */
    public void act() 
    {
        if (getOneIntersectingObject(Target.class)==null)
            move();
        /*
         * First and foremost, the arrow needs to go somewhere.
         * There's a nice method provided below called move. That will move the arrow for you,
         * as well as controlling its rotation.
         * 
         * However, the arrow needs to stop moving sometimes, namely when it hits the target!
         * It also needs to be removed from the world when it's gone out of bounds. The remove() method is provided for removing it from the world.
         * 
         * Arrows also do not last forever. After their life has expired, they need to be removed as well.
         * The life field starts at 500. It should decrease by 1 each turn, and be removed when it reaches 0.
         */ 
        life--;
        if (life < 1)
        remove();
        
        if (getY() >= world.getHeight()-10 || getX() >= world.getWidth()-10 || getX() <10 || getY() <10)
        remove();
        
 
    }
    
    /**
     * Moves the arrow
     */
    private void move()
    {
        setLocation(getX()+(int)force.getX(), getY()+(int)force.getY());
        setRotation(force.getDirection());
        force.add(new Vector(90, 0.3));  
    }
    
    /**
     * Called if this is the last arrow before the player runs out.
     */
    public void setLast()
    {
        last = true;
    }
    
    /**
     * Remove this arrow from the world. If it is the last arrow, then call the game over method in world.
     */
    private void remove()
    {
        if(last) {
            TargetWorld world = (TargetWorld)getWorld();
            world.gameOver();
        }
        getWorld().removeObject(this);        
    }
    
    /**
     * Called when the arrow hits the target. A latching variable is used so this method is only executed on the initial hit.
     */
    public void hit()
    {
        if(latch) return;
        latch = true;
        TargetWorld world = (TargetWorld)getWorld();
        world.addScore(100);
    }
}
