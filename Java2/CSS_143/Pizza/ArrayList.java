
/**
 * ArrayList.java forms an ArrayList, stored as an array. It is resizeable as needed, initial size of 100.
 *
 * @author Will O'Keeffe
 * @version 01/24/2018
 */
public class ArrayList<Pizza>
{
    private Object [] data; //initialize array to store data
    private int count; //keeps track of elements in count  
    private int expandedTimes; //keeps track of the k*100 the array size is
    /**
     * Constructor for objects of class ArrayList
     */
    public ArrayList()
    {
        data = new Object [100];//initializes array full of null
        count = 0;
        expandedTimes = 1;
    }
    /**
     * @param object to add to array
     * @param index to add to
     * 
     * insert changes to specified index to object o
     */
    public void insert (Object o, int index){
        //chcecks to see if array needs to be expanded
        if(count == expandedTimes*100){
            expandedTimes ++;//increments to allow for more space
            System.out.println(data.length);
            data = copyWithSpace(data); //creates new array with 100 more spaces, replacing old array
            System.out.println(data.length);
            //checks for object in array at [index]
            if(data[index] != null)
                data[index] = o;
            else{
                data[index] = o;
                count ++;
            }
        }
        else if(count < expandedTimes * 100){   
            if(data[index] != null)
                data[index] = o;
            else{
                data[index] = o;
                count ++;
            }
        }
    }
    public void add(Object o){
        insert(o, count);
    }
    /**
     * @return int size of ArrayList   
     */
    public int size(){
        return count;//count is number of elements in array
    }
    @Override
    /**
     * @return string value of each entry in ArrayList
     * 
     * overrides java built-in toString() method
     * format: data[0], data[1], ... , data[count], 
     */
    public String toString(){
        String retVal = "";
        for(int i = 0; i < count; i++){
            retVal +=  data[i] + ", ";
        }
        return retVal;
    }
    /**
     * @return true if every data is null
     * @return false if found entry
     * 
     * isEmpty checks each value of data to see if null or not null.
     */
    public boolean isEmpty(){
        for(int i = 0; i < data.length; i++){
            if(count == 0)
                return true;
        }
        return false;
    }
    /**
     * @param Object target
     * 
     * @return index of object if found
     * @return -1 if target not found
     * 
     * indexOf finds the index of the target value
     */
    public int indexOf(Object target){
        for(int i = 0; i < data.length; i++){
            if(data[i] == target)
                return i;
        }
        return -1;
    }
    /**
     * equals(ArrayList) comapres the size and each index of the current instance and input ArrayList
     * 
     * @param ArrayList to compare current instance to
     * 
     * @return false if any discrepency is found
     * @return true if none found     
     */
    public boolean equals(ArrayList other){
        if(other.size() != this.size())
            return false;
        for(int i = 0; i < this.size(); i++){
            if(this.get(i) != other.get(i))
                return false;
        }
        return true;
    }
    /**
     * get(int) obtains the value at data[index]
     * 
     * @param index of target
     * 
     * @return data[target]   
     */
    public Object get(int index){
        return data[index];
    }
    /**
     * remove(int) removes object at specified index, returns null if index out of range
     * 
     * @param index to remove
     * 
     * @return Object at index provided that was removed
     */
    public Object remove(int index){
        Object retVal;
        //checks to see if index is not null in array
        try{ 
            if(index < 0 || index > count){
                throw new Exception("Index of " + index + " is out of bounds. Exiting system.");//throws exception with new message
            }
            else{
                for(int i = 0; i < count; i++){
                    if(data[index] == data[i]){
                        retVal = data[index]; 
                        shiftLeft(i);
                        count --;
                        return retVal;
                    }
                }
            }
        }
        catch(Exception e){
            //if exception is caught exit system.
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return null;//here as method requires a return
    }
    /**
     * shiftLeft(int) shifts the elements in the array one to the left from a sepcified index to the end of the data
     * 
     * @param index to shift left from
     */
    private void shiftLeft(int index){
        Object next;
        for(int i = index; i < count-1; i ++){
            next = data[i+1];
            data[i] = next;
        }
    }
    /**
     * copyWithSpace() copies the current data array to a new one with 100 more spaces if the array is full and more data is needed to be stores
     * 
     * @param Object arrray (old data that is 'full')
     * 
     * @return Object array (same content as param array but with 100 more empty spaces)
     */
    private Object [] copyWithSpace(Object [] oldData){
        //new array to copy to
        Object [] newData = new Object[100*expandedTimes];
        for(int i = 0; i < (expandedTimes-1)*100; i ++){
            //replaces array
            newData[i] = oldData[i];
        }
        return newData;
    }
}
