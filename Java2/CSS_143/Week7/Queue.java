
/**
 *  Queue.java extends List.java
 *      this is a queue class (FIFO) data implimented with linkedLists
 *
 * @author Will O'Keeffe
 * @version 02/20/2018
 */
public class Queue extends List
{
    private int top;
    /**
     * Constructor for objects of class Queue
     * default no-args
     */
    public Queue()
    {
         super();
         top = 0;
    }
    /**
     * Constructor for objects of class Queue
     * constructs queue with one data object, top = 1
     */
    public Queue(Object o){
        super.addToStart(o);
        top = 1;
    }
    /**
     * enqueue(Object) adds an object to the front of a queue, increments top up by one
     * follows FIFO concept of queues
     * 
     * @param object to add to top of queue
     */
    public void enqueue(Object o){
        addToStart(o);
        top ++;
    }
    /**
     * Object dequeue removes object from top of queues
     * follows FIFO concept of queues
     * 
     * @return object removed from queue
     */
    public Object dequeue(){
        try{
            top --;
            return remove(top);
        }
        catch(LinkedListException e){
            System.out.println(e.getMessage());
        }
        return -1; //keeps compilier happy
    }
    /**
    * boolean isEmpty() returns boolean value based on top
    *   -top = 0 ==> empty queue
    * 
    * @return true if top = 0
    */
    public boolean isEmpty(){
        return (top == 0);
    }
     /**
    * int size() returns top of queue
    * 
    * @return top of queue
    */
    @Override
    public int size(){
        return top;
    }
    /**
     * This is the driver for Queue.java
     * no param
     * results will display to console
     */
    public static void main (String [] args){
        Queue empty = new Queue();
        Queue one = new Queue();
        Queue multiple = new Queue();

        one.enqueue(5);
        multiple.enqueue(10);
        multiple.enqueue(20);
        multiple.enqueue(30);

        System.out.println("Empty:"+empty);
        System.out.println("One:"+one);
        System.out.println("Multiple:"+ multiple);	

        one.dequeue();
        multiple.dequeue();

        System.out.println("One (upon dequeue):"+one);
        System.out.println("Multiple (upon dequeue):"+ multiple);

        multiple.enqueue(400);
        System.out.println("Multiple(on enqueue):"+ multiple);
        System.out.println("size of empty: " + empty.size());
        System.out.println("size of one: " + one.size());
        System.out.println("size of multiple: " + multiple.size());
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
