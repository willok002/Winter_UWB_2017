
/**
 * Write a description of class Insertion here.
 *
 * @author WillO'Keeffe
 * @version (a version number or a date)
 */
public class Insertion
{
    // instance variables - replace the example below with your own
    private Object [] arr;

    /**
     * insertion sort, primitives
     */
    public void sort(int [] arr)
    {
        int n = arr.length;
        for (int i=1; i<n; i++)
        {
            int key = arr[i];
            int j = i-1;
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }
    /**
     * insertion sort, non-primitives
     */
    public void sort(Object [] arr)
    {
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            Object key = arr[i];
            int j = i-1;
            while (j>=0 && key.compareTo(arr[j]) < 0)
            {
                arr[j+1] = arr[j];
                j --;
            }
            arr[j+1] = key;
        }
    }
}
