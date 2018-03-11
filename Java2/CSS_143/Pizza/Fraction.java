
/**
 * Write a description of class Fraction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Fraction
{
    // instance variables - replace the example below with your own
    private double numerator;
    private double denominator;
    private double ratio;
    /**
     * Constructor for objects of class Fraction
     */
    public Fraction(String fraction)
    {
       String [] split = fraction.split("/");
       numerator = Double.valueOf(split[0]);
       denominator = Double.valueOf(split[1]);
       ratio = numerator/denominator;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public double getRatio()
    {
        return ratio;
    }
    public void setRatio(double newRatio){
        ratio = newRatio;
    }
}
