import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Man that fires arrows.
 * 
 * @version 29/05/08
 */
public class Man extends Actor
{

    private Arrow arrow;
    
    /**
     * Check for a drag.
     */
    public void act() 
    {
        checkDrag();
    }
    
    /**
     * Check whether we have a mouse drag gesture. Then we need to show the force arrow.
     * When the mouse is let go, if there are any arrows left, fire an arrow.
     */
    private void checkDrag()
    {
        TargetWorld world = (TargetWorld)getWorld();
        if(world.getArrows()<=0) return;        
        if(Greenfoot.mouseDragged(null)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            int dx = mouse.getX()-getX();
            int dy = mouse.getY()-getY();
            if (arrow == null) {   // just starting to drag now
                arrow = new Arrow(dx, dy);
                getWorld().addObject( arrow, getX(), getY() );
            }
            else {
                arrow.setImage(dx, dy);
            }
        }
        if(Greenfoot.mouseDragEnded(null) && arrow != null) {
            world.addArrows(-1);
            getWorld().removeObject(arrow);
            arrow = null;
            MouseInfo mouse = Greenfoot.getMouseInfo();
            Vector force = new Vector(new Location(mouse.getX(), mouse.getY()), new Location(getX(), getY()));
            force.scale(0.1);
            FireArrow arrow = new FireArrow(force);
            getWorld().addObject(arrow, getX(), getY());
            if(world.getArrows()<=0) arrow.setLast();
        }
    }    
}
