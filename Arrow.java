package Target;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An arrow showing a force.
 */
public class Arrow extends Actor
{
    private GreenfootImage image;  // original, full size image
    
    public Arrow()
    {
        this (150, 150);
    }
    
    public Arrow(int dx, int dy)
    {
        image = getImage();
        setImage(dx, dy);
    }
    
    public void setImage(int dx, int dy)
    {
        int direction = (int) Math.toDegrees(Math.atan2(dx, dy));
        int length = (int) Math.sqrt(dx*dx+dy*dy) + 30;

        GreenfootImage img = new GreenfootImage(image);
        img.scale(length*2, 300);
        setRotation(-direction-90);
        setImage(img);
    }
}
