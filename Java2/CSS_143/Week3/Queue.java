
/**
 * Queue forms a FIFO array, with initial capacity of 100. Resizes as needed.
 *
 * @author Will O'Keeffe
 * @version 01/24/2018
 */
public class Queue
{
    // instance variables - replace the example below with your own
    private Object [] data;
    int top;//keeps track of the top value of array
    int expandedTimes ;//keeps track of number of times list has been expanded
    /**
     * Constructor for objects of class Queue
     * creates new array with 100 data spots
     *
     */
    public Queue()
    {
        data = new Object[100];
        top = 0;
        expandedTimes = 1;
    }
    /**
     * enque adds the input to the top of the queue
     *
     * @param o   the object to add to the queue
     */
    public void enqueue(Object o){
        //checks to see if we need to add room in list

        if(top/100 == expandedTimes){
            expandedTimes ++;//increments for use in copyWithSpace(Queue)
            data = copyWithSpace(data);
            data[top] = o;//adds to top
            top ++;
        }
        else if(top < expandedTimes * 100){
            data[top] = o;
            top ++;
        }
    }
    /**
     * deque() removes object from the bottom of queue
     * @return the object at the bottom of the queue
     */
    public Object dequeue(){
        Object retVal = data[0];
        shiftLeft(0);
        top --;
        return retVal;
    }
    /**
     * @return  size of queue
     * returns the value of the top of the queue
     */
    public int size(){
        return top;
    }
    /**
     * OVERRIDES String toString
     * returns the whole queue in order to be accessed
     * format: 1, 2, 3, ..., n,
     *
     * @return String value of the list of elements in queue
     */
    @Override
    public String toString(){
        String retVal = "";
        for (int i = 0; i < top; i ++){
            retVal += data[i] + ", ";
        }
        return retVal;
    }
    /**
     * @return boolean  based on content of first obj. to be accessed
     *
     */
    public boolean isEmpty(){
        if(top == 0)
            return true;
        return false;
    }
    /**
     *
     */
    public boolean equals(Object other){
        if (data[0] != other)
            return false;
        return true;
    }
    /**
     * copyWithSpace() copies the current data array to a new one with 100 more spaces if the array is full and more data is needed to be stores
     *
     * @param Object arrray (old data that is 'full')
     *
     * @return Object array (same content as param array but with 100 more empty spaces)
     */
    private Object [] copyWithSpace(Object [] oldData){
        Object [] newData = new Object[100*expandedTimes];
        for(int i = 0; i < (expandedTimes-1)*100; i ++){
            newData[i] = oldData[i];
        }
        return newData;
    }
    /**
     * shiftLeft shifts the elements in the array one to the left from a sepcified index to the end of the data
     *
     * @param index to shift left from
     */
    private void shiftLeft(int index){
        Object next;
        for(int i = index; i < top-1; i ++){
            next = data[i+1];
            data[i] = next;
        }
    }
}
