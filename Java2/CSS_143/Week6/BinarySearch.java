
/**
 * BinarySearch.java provides both an iterative and recursive solutions to a binary search
 *
 * @author Will O'Keeffe
 * @version 02/15/2-18
 */
public class BinarySearch extends SearchAlgorithm

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
     * search(String [], String) is an iterative approach to a binary search of a sorted string file
     *  -throws ItemNotFoundException if we get to end of file whithout finding word
     *
     * @param array of words to search through
     * @param target to look for
     * 
     * @return index of target if found
     * 
     */
    public int search(String [] words, String target) throws ItemNotFoundException{
        int i = words.length /2;
        int bottom = 0;
        int top = words.length;
        while (bottom <= top){
            incrementCount();
            if(words[i].equals(target))
                return i;
            else if(target.compareTo(words[i]) > 0){
                bottom = i +1;
                i = ((top + i+1)/2);
            }
            else{
                top = i-1;
                i = (bottom + top )/2;
            }
        }
        //if we get here its not found
        throw new ItemNotFoundException(target + " not found in provided list.");
    }
    /**
     * recSearch(String [], String) is recursive approach to a binary search of a sorted string file using binarySearch(String [], String, int, int)
     *  -throws ItemNotFoundException if we get to end of file whithout finding word
     *
     * @param array of words to search through
     * @param target to look for
     * 
     * @return index of target if found
     * 
     */
    public int recSearch(String [] words, String target) throws ItemNotFoundException
    {
        int top = words.length;
        int bottom = 0;
        return binarySearch(words, target, top, bottom);
    }
    /**
     * binarySearch(String [], String) is recursive approach to a binary search of a sorted string file
     *  -throws ItemNotFoundException if we get to end of file whithout finding word
     *
     * @param array of words to search through
     * @param target to look for
     * 
     * @return index of target if found
     * 
     */
    private int binarySearch(String [] words, String target, int top, int bottom) throws ItemNotFoundException{
        incrementCount();
        int mid = top + bottom /2;
        if(bottom > top)
            throw new ItemNotFoundException(target + " not found in provided list.");
        if(target.equals(words[mid]))
            return mid;
        else if (target.compareTo(words[mid]) > 0)
            return binarySearch(words, target, top, mid+1);
        else 
            return binarySearch(words, target, mid+1, bottom);
    }
}
