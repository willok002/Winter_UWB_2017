
/**
 * Write a description of class BinarySearch here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BinarySearch

{
    private int lowIndex;
    private int highIndex;

    /**
     * Constructor for objects of class BinarySearch
     */
    public BinarySearch()
    {   
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int search(String [] words, String target) throws ItemNotFoundException
    {
        int top = words.length;
        int bottom = 0;
        return binarySearch(words, target, top, bottom);
    }
    private int binarySearch(String [] words, String target, int top, int bottom) throws ItemNotFoundException{
        int mid = top + bottom /2;
        if(bottom > top)
            throw new ItemNotFoundException("Item not found");
        if(target.equals(words[mid]))
            return mid;
        else if (target.compareTo(words[mid]) > 0)
            return binarySearch(words, target, top, mid+1);
        else 
            return binarySearch(words, target, mid+1, bottom);
    }
}
