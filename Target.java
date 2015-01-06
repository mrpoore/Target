import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * A target that players hit for 100 points.
 * 
 * @author Richard Poore
 * @version 20141211
 */
public class Target extends Actor
{

    private String direction = "down";
    private int speed = 1;
    private TargetWorld world;
    
    /**
     * Called when the target is added to the world.
     */
    public void addedToWorld(World world)
    {
        this.world = (TargetWorld)world;
    }
    
    /**
     * Move the target up and down. Randomly create balloons in the world.
     */
    public void act() 
    {
        
        /*
         * You need to implement code here to:
         * 
         * 1. Get the target to move up and down.*/
         if (getY() > getWorld().getHeight()-80)
         {
            direction = "up";
         }
         if (getY() < 50) {
            direction = "down";
         }
         if (direction.equals("down"))
            setLocation(this.getX(), getY()+speed);
         else
            setLocation(this.getX(), this.getY()-speed);
         
         /* 2. Randomly create 3 kinds of balloons throughout the world:
         *      - Blue balloons */
            if(Greenfoot.getRandomNumber(500)==0)
            world.addObject(new BlueBalloon(), Greenfoot.getRandomNumber(getWorld().getWidth()-80), getWorld().getHeight()) ;
         /*     - Yellow balloons */
            if(Greenfoot.getRandomNumber(400)==0)
            world.addObject(new YellowBalloon(), Greenfoot.getRandomNumber(getWorld().getWidth()-80), getWorld().getHeight()) ;
         /*
         *      - Red balloons */
            if(Greenfoot.getRandomNumber(300)==0)
            world.addObject(new RedBalloon(), Greenfoot.getRandomNumber(getWorld().getWidth()-80), getWorld().getHeight()) ;
         /*
         *      
         * The balloon classes are all provided for you complete.
         */
        
        //This part can be left alone. It makes sure the arrows that are stuck to the target move up and down with it.
        List<FireArrow> arrows = getIntersectingObjects(FireArrow.class);
        
        for(FireArrow arrow : arrows) {
            arrow.hit();
            if(direction.equals("down")) 
                arrow.setLocation(arrow.getX(), arrow.getY()+speed);
            else 
                arrow.setLocation(arrow.getX(), arrow.getY()-speed);
        }        
    }    
}

