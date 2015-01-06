package Target;

/**
 * A Location in the world. This class is often used with the SmoothMover class (or 
 * similar classes). It provides more precise location (and with this: smoother movement)
 * than the standard actor. It implements the location co-ordinates as doubles, rather
 * than ints, and can thus deal with sub-pixel movement.
 * 
 * @author mik
 * @version 1.1
 */

public final class Location
{
    public static final Location NONE = new Location(-1.0, -1.0);
    
    private double x;
    private double y;

    /**
     * Constructor for objects of class Location
     */
    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
     
    public double getY() {
        return y;
    }
    
    public void move(double dx, double dy) {
        x = x + dx;
        y = y + dy;
    }
    
    public boolean equals(Object other)
    {
        if(other instanceof Location) {
            Location o = (Location) other;
            return (x == o.x) && (y == o.y);
        }
        else
            return false;
    }
}
