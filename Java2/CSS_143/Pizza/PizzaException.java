
/**
 * PizzaException is used in Pizza Simulator project
 *
 * @author Will O'Keeffe
 * @version 03/09/2018
 */
public class PizzaException extends Exception
{
    /**
     * Constructor for objects of class PizzaException
     * default no-args
     */
    public PizzaException()
    {
       super();
    }
    /**
     * Constructor for objects of class PizzaException
     * @param message to display
     */
    public PizzaException(String message)
    {
       super(message);
    }
}
