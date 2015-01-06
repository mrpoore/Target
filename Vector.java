package Target;

import greenfoot.Greenfoot;

/**
 * A 2D vector.
 * 
 * @author Poul Henriksen
 */
public final class Vector
{
    double dx;
    double dy;
    int direction;
    double length;
    
    /**
     * Return a random vector with defined length limit.
     */
    public static Vector getRandom(int maxLength)
    {
        return new Vector (Greenfoot.getRandomNumber(360), Greenfoot.getRandomNumber(maxLength));
    }
        
    /**
     * Create a new, neutral vector.
     */
    public Vector()
    {
    }

    /**
     * Create a vector with given direction and length. The direction should be in
     * the range [0..359], where 0 is EAST, and degrees increase clockwise.
     */
    public Vector(int direction, double length)
    {
        this.length = length;
        this.direction = direction;
        updateCartesian();
    }

    public Vector(Location start, Location end)
    {
        dx = end.getX() - start.getX();
        dy = end.getY() - start.getY();
        updatePolar();
    }

    /**
     * Set the direction of this vector.
     */
    public void setDirection(int direction) {
        this.direction = direction;
        updateCartesian();
    }
   
    /**
     * Add other vector to this vector.
     */
    public void add(Vector other) {
        dx += other.dx;
        dy += other.dy;
        updatePolar();
    }
    
    public void reduceLength(double d) {
        length = length - d;
        updateCartesian();
    }
    
    public void scale(double factor) {
        length = length * factor;
        updateCartesian();
    }
    
    public void setNeutral() {
        dx = 0.0;
        dy = 0.0;
        length = 0.0;
        direction = 0;
    }
    
    /**
     * Update the direction and length fom the current dx, dy.
     */
    private void updatePolar() {
        this.direction = (int) Math.toDegrees(Math.atan2(dy, dx));
        this.length = Math.sqrt(dx*dx+dy*dy);
    }   
    
    /**
     * Update dx and dy from the current direction and length.
     */
    private void updateCartesian() {
        dx = length * Math.cos(Math.toRadians(direction));
        dy = length * Math.sin(Math.toRadians(direction));   
    }   

    private void check() {
//         if(length > 1000) {
//             throw new IllegalStateException();
//         }
    }
    
    public double getX() {
        return dx;
    }
     
    public double getY() {
        return  dy;
    }
    
    public int getDirection() {
        return direction;
    }
    
    public double getLength() {
        return length;
    }
    
    /**
     * Create a copy of this vector.
     */
    public Vector copy() {
        Vector copy = new Vector();
        copy.dx = dx;
        copy.dy = dy;
        copy.direction = direction;
        copy.length = length;
        return copy;
    }
    
    /**
     * Create a copy of this vector.
     */
    public Vector reverse() {
        Vector copy = new Vector();
        copy.dx = -dx;
        copy.dy = -dy;
        copy.direction = (direction + 180) % 360;
        copy.length = length;
        return copy;
    }
    
    public String toString() {
        return "[" + direction + " " + length + " / " + dx + "," + dy + "]";
    }
}