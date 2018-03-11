
/**
 * Write a description of class Selection here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Selection
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Selection
     */
    public Selection()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * Selection sort for primitive array
     *
     * @param  array of primitives to sort 
     */
    public void selectSort(int [] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++){
            int minIndx = i;
            //checks to see if smaller element exisits in array
            for (int j = i+1; j < n; j++){
                if (arr[j] < arr[minIndx])//compares, updates if smaller exists
                    minIndx = j;
             }
            //stores smallest as temp for swapping purposes
            int temp = arr[minIndx];
            arr[minIndx] = arr[i];
            arr[i] = temp;
        }
    }
    /**
     * Selection sort for non-primitive array
     *
     * @param  array of non-primitaves to sort 
     */
    public void selectSort(Object [] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++){
            int minIndx = i;
            //checks to see if smaller element exisits in array
            for (int j = i+1; j < n; j++){
                if (arr[j].compareTo( arr[minIndx]) < 0)//compares, updates if smaller exists
                    minIndx = j;
             }
            //stores smallest as temp for swapping purposes
            Object temp = arr[minIndx];
            arr[minIndx] = arr[i];
            arr[i] = temp;
        }
    }
}
