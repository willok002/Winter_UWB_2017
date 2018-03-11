
/**
 * Money.java generates a monetary value represented as a double. 
 * Conditions are no negative values for Money are allowed
 *
 * @author Will O'Keeffe
 * @version 01/28/2018
 */
public class Money implements Comparable
{
    // instance variables - replace the example below with your own
    private int cents;
    private int dollars;

    /**
     * Constructor for objects of class Money
     * takes dollars as an input
     * @param dollars
     * 
     * preconditions: dollars amount >= 0
     *  -will set to -1 if not met
     */
    public Money(int dol)
    {
        if(dol >= 0)
            dollars = dol;
        
        else{
            System.out.println("Fatal error: Negative entry. Data set to -1.");
            dollars  = -1;
        }
    }
    /**
     * Constructor for objects of class Money
     * @param dollars 
     * @param cents
     * 
     * preconditions: dollars AND cents enters >= 0.
     *  -sets value to -1 if not met
     */
    public Money(int dol, int cent){
        if(dol >= 0 && cent >= 0){
            //handles case of >100 cents entered
            if (cent >= 100){
                dollars = dol + cent / 100;
                cents = cent-cent/100;
            }
            else{
                dollars = dol;
                cents = cent;
            }
        }
        else{
            System.out.println("Fatal error: Dollars or Cents ammount entered is less than 0.");
            dollars =1;
            cents = -1;
        }
    }
    /**
     * Copy constructor of class Money
     * @param other Money object
     * 
     * preconditions of Money class already met
     */
    public Money (Money other){
        dollars = other.dollars;
        cents = other.cents;
    }
    /**
     * @return dollar amount of current instance
     */
    public int getDollars(){
        return dollars;
    }
    /**
     * @return cents variable amount of current instance
     */
    public int getCents(){
        return cents;
    }
    /**
     * Sets cents variable to new ammount
     * @param new amount for cents to be equal to
     * 
     * precondition: new value >= 0
     *  -does not change value if not met
     */
    public void setCents(int cent){
        if(cent >= 0)
            cents = cent;
        else{
            System.out.println("Fatal error: Cents enterd is negative. Data not changed");
        }
    }
    /**
     * Sets dollars variable to new ammount
     * @param new amount for dollars to be equal to
     * 
     * precondition: new value >= 0
     *  -does not change value if not met
     */
    public void setDollars(int dol){
        if(dol >= 0)
            dollars = dol;
        else{
            System.out.println("Fatal error: Dollars entered is negative. Data not changed");
        }
    }
    /**
     * Sets cents and dollars variables to new ammount
     * @param new amount for cents to be equal to
     * @param new amount for dollars to be equal to
     * 
     * precondition: new values >= 0
     *  -sets value to -1 if not met
     */
    public void setMoney(int dol, int cent){
        if(dol >= 0 && cent >= 0){
            setDollars(dol);
            setCents(cent);
        }
        else{
            System.out.println("Fatal error: Negative value(s) entered. Data not changed");
        }
    }
    /**
     * increments dollars by cents
     * @param amount to increment by (can be negative
     * 
     * precondition: amount to incrememnt by (if negative) is less in abs value than current dollar amount
     *  -does not change data if not met
     */
    public void add(int dol){
        if(dol >= 0)
            dollars += dol;
        else if(dol < 0 && -dol <= dollars)
            dollars += dol;
        else{
            System.out.println("Fatal error: Executing the change of $"+ dol + " will result in a negative balance. Data not changed");
        }
    }
    /**
     * adds dollars and cents together
     * if cent value >= 100, adds the cent/100 value to dollars, and the remainder to cents
     * @param value to increment dollars and cents by
     * 
     * precondition: ammount to increment by will not result in a negative value
     *  -does not change data if not met
     */
    public void add(int dol, int cent)throws PizzaException{
        //case of negative amounts enterd, only case with possible negative value after update
        if(dol < 0 || cent < 0){
            if(dollars - dol < 0 || dollars - cent/100 < 0 || cents - cent%100 < 0){
                throw new PizzaException("Fatal error:  Executing the change of $"+ dol +
                "." + cent + " will result in a negative balance. Data not changed.");
            }
        }
        else{
            if(cent >= 100){
                dollars += (dol + cent/100);
                cents += (cent%100);
            }
            else{
                dollars += dol;
                cents += cent;
            }
        }
    }
    /**
     * test to see if other object is equal to current Money object
     * @param another object
     * @return false if null or not Money object OR if cents != cents or dollars != dollars
     *  -true else
     */
    public boolean equals(Object other){
        if(other == null || !(other instanceof Money)){
            return false;
        }
        Money that = (Money) other;
        if(that.cents == this.cents && that.dollars ==this.dollars)
            return true;
        return false;
    }
    /**
     * Overrides java's built-in toString class
     * @return String value of dollar format of amount represented
     *  format is: $dollars.cents
     */
    @Override
    public String toString(){
        if(dollars >= 0 && cents >=0)
            return "$" + (dollars +cents/100) +  "." + cents%100;
        return "Invalid data";
    }
    /**
     * @return amount of money in current instance (double)
     */
    public double getMoney()
    {
        return dollars + ((double)cents/100);
    }
    /**
     * Overrrides Comparable interface's compareTo(Object) method
     * @param object to compare to
     * @return integer value of less, greater, equals (-1, 1, 0 respectively)
     */
    public int compareTo(Object other){
        if(other == null || !(other instanceof Money))
            return -5;
        Money that = (Money) other;
        if( dollars > that.dollars)
            return 1;
        else if (dollars < that.dollars)
            return -1;
        else{
            if(cents > that.cents)
                return 1;
            else if(cents < that.cents)
                return -1;
        }            
        return 0; //if we get here they are equal
        
    }
}