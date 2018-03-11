
/**
 * circle.java extends Shape.java
 * creates circle object
 * 
 * -----this is from lab-----
 *
 * @author Will O'Keeffe
 * @version 01/04/2018
 * 
 */
import static java.lang.Math.PI;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
//importsnecessary libraries
public class Circle extends Shape
{
    // instance variables 
    private double radius;

    /**
     * Constructor for objects of class Circle
     * --precondition: nums > 0
     */
    public Circle(int x, int y, int radius)
    {
        super(x,y);
        if (radius > 0)
            this.radius = radius;
        else{
            System.out.println("Invalid input for radius in Circle.");
            System.exit(0);
        }
    }
    /**
     * Overrides getArea() in Shape.java
     * retuns double value of area
     */
    @Override
    public double getArea(){
        return (Math.PI * radius * radius);
    }
    /**
     * overrides draw(Graphics) of Shape.java
     */
    @Override
    public void draw(Graphics g){
        final int x = getX();
        final int y = getY();
        g.drawOval(x,y,2*(int)radius,2*(int)radius);
    }
    /**
     * @return radius of object
     */
    public double getRadius(){
        return radius;
    }
    /**
     * sets radius to new value
     * @param new radius
     * --precondition: radius > 0
     */
    public void setRadius(double radius){
        if (radius > 0)
            this.radius = radius;
        else{
            System.out.println("Invalid input for radius in Circle.");
            System.exit(0);
        }
    }
}
