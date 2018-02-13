
/**
 * Stack.java forms a LIFO array, with initial capacity of 100. Adds size if needed.
 *
 * @author Will O'Keeffe
 * @version 01/24/2018
 */
public class Stack
{
    //initializes necessary variables
    private Object [] data;
    private int top;
    private int expandedTimes;
    /**
     * Constructor for objects of class Stack
     * initiates stack with size 100
     * intitates top at -1
     * intiates expandedTimes to 1
     */
    public Stack()
    {
        data = new Object[100];
        top = -1; //initialized at -1 for toString() and pop() to not return any null values
        expandedTimes = 1;
    }
    /**
     * push (Object) adds object to top of stack
     *
     * @param  o  Object to add to stack 
     */
    public void push(Object o){
        //checks to see if array needs to be expanded
        if(top+1 == expandedTimes*100){
            expandedTimes ++;//increased for use in copywWithSpace(data);
            data = copyWithSpace(data);
            top ++;
            data[top] = o;           
        }
        else if(top < expandedTimes * 100){
            top ++;
            data[top] = o;
        }
    }  
    /**
     * pop() returns the object at top of stack after deleting it 
     *
     * @return  Object at top of stack
     */
    public Object pop(){
        Object retVal;
        retVal = data[top];
        data[top] = null;
        top --;
        return retVal;   
    }
    /**
     * size() returns the size of the stack
     *
     * @return  integer value of size of stack
     */
    public int size(){
        return top; //top represents the top of stack
    }
    /**
     * toString() overrides the built in class toString()
     * returns the string value of all stack elements from top --> bottom
     * format: top, top-1, top-2,..., bottom, 
     *
     * @return String of stack values top --> bottom
     */
    @Override
    public String toString(){
        String retVal = "";
        for (int i = top; i >= 0; i --){
            retVal += data[i] + ", ";
        }
        return retVal;
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean isEmpty(){
        if(top  < 0) //checks top value, as it will decrement to -1 if it is empty.
            return true;
        return false;
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean equals(Object other){
        if (data[top] != other)
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
}
