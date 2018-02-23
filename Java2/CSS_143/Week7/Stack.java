
/**
 * Write a description of class Stack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Stack extends List 
{
    private int size;

    /**
     * Constructor for objects of class Stack
     * default no-args
     */
    public Stack()
    {
        super();
        size = 0;
    }
    /**
     * Constructor for objects of class Stack
     * constructs stack with one data object, size = 1
     */
    public Stack(Object data){
        super.addToStart(data);
        size = 1;
    }

    /**
     * push(Object) adds an object to the top of a stack, increments size up by one
     * follows LIFO concept of stack
     * 
     * @param object to add to top of stack
     */
    public void push(Object o)
    {
        addToStart(o);
        size ++;
    }
    /**
     * Object pop removes object from top of stacks
     * follows LIFO concept of stacks
     * 
     * @return object removed from stack
     */
    public Object pop(){
        try{
            size --;//increments down for size index purposes
            return remove(0);
        }
        catch(LinkedListException e){
            System.out.println(e.getMessage());
        }
        return -1;//keeps compiler happy
    }
   /**
    * boolean isEmpty() returns boolean value based on size
    *   -size = 0 ==> empty stack
    * 
    * @return true if size = 0
    */
    public boolean isEmpty(){
        return(size == 0);
    }
    /**
    * int size returns size of stack
    * 
    * @return size of stack
    */
    @Override
    public int size(){
        return size;
    }
    /**
     * This is the driver for Stack.java
     * No param
     * All tests will print to console
     */
    public static void main (String [] args){
        Stack empty = new Stack();
        Stack one = new Stack();
        Stack multiple = new Stack();

        one.push(5);
        multiple.push(10);
        multiple.push(20);
        multiple.push(30);

        System.out.println("Empty:"+empty);
        System.out.println("One:"+one);
        System.out.println("Multiple:"+ multiple);	

        one.pop();
        multiple.pop();

        System.out.println("One (upon pop):"+one);
        System.out.println("Multiple (upon pop):"+ multiple);

        multiple.push(400);
        System.out.println("Multiple(on push):"+ multiple);
        System.out.println("Size of empty: " + empty.size());
        System.out.println("Size of one: " + one.size());
        System.out.println("Size of multiple: " + multiple.size());
        System.out.println();
        System.out.println("Testing isEmpty()");
        System.out.println("empty: " + empty.isEmpty());
        System.out.println("one: " + one.isEmpty());
        System.out.println("multiple: " + multiple.isEmpty());
        System.out.println();
        System.out.println("Testing indexOf()");
        System.out.println("30 in multiple: " + multiple.indexOf(30));
        System.out.println("-5 in multiple: " + multiple.indexOf(-5));
    }
}
