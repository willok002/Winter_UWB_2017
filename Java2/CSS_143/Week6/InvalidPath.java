
/**
 * Write a description of class InvalidPath here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InvalidPath extends Exception
{
    /**
     * Constructor for objects of class InvalidPath
     */
    public InvalidPath(String message)
    {
       super(message + " is not a valid file path.");
    }
}
