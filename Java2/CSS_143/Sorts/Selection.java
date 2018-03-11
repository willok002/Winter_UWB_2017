
/**
 * Selection.java contains primitave and non-primative selection sorts
 *
 * @author Will O'Keeffe
 * @version 03/09/2018
 */
public class Selection
{
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
