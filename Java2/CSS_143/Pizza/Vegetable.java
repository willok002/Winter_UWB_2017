
/**
 * Write a description of class Vegetable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
public class Vegetable extends Ingredient
{
    private Color color;
    /**
     * Constructor for objects of class Vegetable
     */
    public Vegetable(String description, Money cost, int calories)
    {
        super(description, cost, calories);
    }
    public Vegetable(Color color, Money cost, int calories){
        super(color.toString(), cost, calories);
    }
    public Color getColor(){
        return color;
    }
    public void setColor(Color newColor){
        color = newColor;
    }    
    public String toString(){
        return color.toString() + " " + super.toString();
    }
    public boolean equals(Object other){
        if(other == null || !(other instanceof Vegetable))
            return false;
        Vegetable that = (Vegetable) other;
        if(that.color != color)
            return false;
        else{
            return super.equals(that);
        }
            
             
    }
}
