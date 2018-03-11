import java.awt.*;

/* Class Shape
 *
 * By Rob Nash (with minor edits by Johnny Lin)
 * 
 * This is the superclass in a hierarchy of shapes that you have to construct
 */

//the superclass in our inheritance hierarchy
//all "common" features, functions and data should go here
//for example, all shapes in Java2D have a x,y that declares their position
//and many of the shapes exposed have a width and a height 
//(but not all, so we didn't put width and height here)
//note that this class is mostly empty, as there is no algorithm generic 
//enough to guess an arbitrary shape's area (future subclasses must override getArea() 
//to provide something reasonable)
//also, the draw method is empty too, as we don't know what shape to draw here! 
//(again, our subclasses will need to replace this method with one that actually draws things)

class Shape extends Object {
	private int x = 0;
	private int y = 0;
	
	public Shape( int a, int b ) {
		x=a;
		y=b;
	}
	public double getArea(){ 
	    return -1; 
	}
	public void draw( Graphics g ){
	}
	public int getX() { 
	    return x; 
	}
	public int getY() {
	    return y; 
	}
	public void setX(int value) {
	    x = value; 
	}
	public void setY(int value) {
	    y = value; 
	}
}
