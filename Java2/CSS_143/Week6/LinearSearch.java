
/**
 * Write a description of class LinearSearch here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinearSearch{
    
    /**
     * Constructor for objects of class LinearSearch
     */
    public LinearSearch()
    {
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int search(String [] toSearch, String target) throws ItemNotFoundException
    {
        for(int i = 0; i < toSearch.length; i++){
            //incrementCount();
            if(toSearch[i].equals(target))
                return i;  
        }
        throw new ItemNotFoundException(target + " is not in provided list.");
        //return -1;//makes compiler happy, will not reach here
    }
}
