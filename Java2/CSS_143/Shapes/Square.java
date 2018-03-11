/**
 * This is submitted so Cube will run properly
 * @author Rob Nash
 */
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
class Square extends Shape  {
    private int sideLength;
    /**
     * Creates square with area = 0
     */
    public Square(int a, int b) {
        super(a, b);   //we explicitly call a superclass constructor 
                       //  that takes 2 ints, as in Shape, because we
                       //  get a compiler error otherwise.  However,
                       //  you should write a constructor that is able
                       //  to accept more info., such as the sideLength,
                       //  since you need this info. to draw a square.
    }
    /**
     * creates square, sideLength= nonnegative
     */
    public Square(int x, int y, int sideLength){
        super(x,y);
        this.sideLength = sideLength;
    }
    /**
     * returns value of SideLegnth
     */
    public int getSide(){
        return sideLength;
    }
    /**
     * @param new side length
     * sets sideLegnth to nSide(nonnegative)
     */
    public void setSide(int nSide){
        sideLength = nSide;
    }
    /**
     * @return value of area of square
     */
    public double getArea() {
        return sideLength * sideLength; 
    }
    /**
     * Overrides draw(Graphics) in Shape.java
     * 
     * draws square in Jframe
     */
    public void draw(Graphics g) {
        g.fill3DRect(getX(), getY(), sideLength, sideLength, false);
    }
}
