
/**
 *CSS143 week 2 lab 1: Fraction.
 *
 * @author Will O'Keeffe
 * @version 01/16/2018
 */
public class Fraction
{   
    private double numerator ;
    private double denominator;
    /**
     * Constructor for objects of class Fraction
     */
    public Fraction()
    {
    }
    /**
     * Constructor for objects of class Fraction
     * @param new numerator (int)
     * @param new denominator (int)
     */
    public Fraction(int newN, int newD){       
            numerator = newN;
            denominator = newD;
    }
    /**
     * Constructor for objects of class Fraction
     * @param new numerator (double)
     * @param new denominator (double)
     */
    public Fraction(double newN, double newD){
            numerator = newN;
            denominator = newD;
    }
    /**
     * Returns truth of fractoins equaling each other based on ratios
     * @param Fraction other: a fraction to cmpare current fraction instance to
     * @return boolean: true if equal ratio false otherwise
     */
    public boolean equals(Fraction other){
        if(this.numerator/this.denominator == other.numerator/other.denominator)
            return true;
        return false;
    }
    @Override
    /**
     * @return string of the fraction
     */
    public String toString(){
        return numerator + "/" + denominator;
    }
    /**
     * @return numerator (double)
     */
    public double getNumerator(){
        return numerator;
    }
    /**
     * @return denominator(double)
     */
    public double getDenominator(){
        return denominator;
    }
    /**
     * @param int new numerator
     * @param int new denominator
     */
    public void setFraction(int newN, int newD){
        if(newN % newD == 0){
            numerator = newN/newD;
            denominator = 1;
        }
        else{
            numerator = newN;
            denominator = newD;
        }
    }
    /**
     * @param int new numerator
     * @param int new denominator
     */
    public void setFraction(double newN, double newD){
        if(newN % newD == 0){
            numerator = newN/newD;
            denominator = 1;
        }
        else{
            numerator = newN;
            denominator = newD;
        }
    }
}
