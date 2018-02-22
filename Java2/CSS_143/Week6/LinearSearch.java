
/**
 *  LinearSearc.java provides iterative and recursive options for a linear search
 *
 * @author Will O'Keeffe
 * @version 01/12/2018
 */
public class LinearSearch extends SearchAlgorithm{
    
    /**
     * Constructor for objects of class LinearSearch
     * no pram taken
     */
    public LinearSearch()
    {
    }
    /**
     * search searches array for target from start to target found (iterative)
     *  if not found we are at end of arrray, we throw new ItemNotFoundException
     * 
     *  @param array of words to search
     *  @param target word
     *  
     *  @return index in array of target if found, throws exception if not found
     */
    public int search(String [] toSearch, String target) throws ItemNotFoundException
    {
        for(int i = 0; i < toSearch.length; i++){
            incrementCount();
            if(toSearch[i].equals(target))
                return i;  
        }
        //if we get here target is not in list
        throw new ItemNotFoundException(target + " is not in provided directory.");
    }
    /**
     * search searches array for target from start to target found (recursive)
     *  if not found we are at end of arrray, we throw new ItemNotFoundException
     * 
     *  @param array of words to search
     *  @param target word
     *  
     *  @return index in array of target if found, throws exception if not found
     */
    public int recSearch(String [] toSearch, String target) throws ItemNotFoundException{
        if(toSearch[getCount()].equals(target)){
            incrementCount();
            return getCount();
        }
        else{
            incrementCount();
            recSearch(toSearch, target);
        }
        throw new ItemNotFoundException(target + " is not in provided directory.");
    }
}
