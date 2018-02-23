
/**
 * List.java is the List parent class for Stack.java and Queue.java (linkedlist based)
 * Contains inner class Node.java
 *
 * @author Will O'Keeffe 
 * @version 2/20/2018
 */
public class List
{
    private Node head;//instance variable
    /**
     * Node.java is inner class for List.java
     * Node.java is used to create links and store data for Link.java
     * 
     * @author Will O'Keeffe
     * @version 2/20/2018
     */
    private class Node{
        //instance variables
        private Node link;//pointer to next node
        private Object item;//data for current node
        /**
         * constructor for Node.java
         * @param data to hold
         * @param link to next object, null if end of list
         */
        public Node(Object newItem,  Node linkValue){
            setData(newItem);
            link = linkValue;
        }
        /**
         * setData(Object) sets data for specified node
         * @param new data for node
         */
        public void setData(Object newItem){
            item = newItem;
        }
         /**
          * setLink(Node) changes current link for specified node
          * @param new node to point to
          */
        public void setLink(Node newLink){
            link = newLink;
        }
        /**
         * Node getLink() returns the link value of next node
         * used to shift down linkedList
         * 
         * @return link of current node
         */
        public Node getLink(){
            return link;
        } 
        /**
          * Object getData() returns item at node
          * @return data for specified node
          */
        public Object getData(){
            return item;
        }
    }
    /**
     * default no-args constructor for List.java
     * sets head to null ==> empty list
     */
    public List(){
        head = null;
    }
    /**
     * addToStart(Object) adds new item to start
     * sets node to previous head
     * @param item to add to head
     */
    public void addToStart(Object item){
        head = new Node(item, head);
    }
    /**
     * insert(Object, int) inserts a new node at specified index
     * 
     * @param item to insert
     * @param index to insert at
     * 
     */
    public void insert(Object item, int index){
        Node current = head;
        int counter = 0;//poposition counter
        if (current == null)//head null
            head = new Node(item, head);//same as addToStart()
        else{
            while (counter < index-1){
                current = current.getLink();//move along list
                counter ++;
            }
            current.setLink(new Node(item, current.getLink()));//link set to object previously after current after insertion
        }
    }
    /**
     * Object remove (int) thorws LinkedListException if head is null (list empty)
     * remove removes the node at a provided index and returns it's data
     * 
     * @param index to remove at
     * @return data of node at index provided
     * 
     */
    public Object remove(int index) throws LinkedListException{
        Object retVal;
        if(head == null)//empty list
            throw new LinkedListException("Cannot delete from an empty list");
        else if(head.getLink() == null){//single-element case
            Object data = head.getData();
            head =null;
            return data;
        }
       else{
           int count = 0; //keeps track of index
           Node current = head;//start at head
           while(count < index-1){
               current = current.getLink();
               count ++;
           }
           retVal = current.getData();
           if(current.getLink().getLink()!= null)//if next is not end of list
               current.setLink(current.getLink().getLink());//sets previous index link to index after target
           else{
               current.setLink(null);//else we're at end of list
           }
       }
       return retVal;
    }
    /**
     * int size() returns the size of list
     * @return size of list
     */
    public int size(){
        int count = 0;//keeps track of position
        Node current = head;//start at head
        if(current == null)//empty list case
            return count;//size = 0
        while (current != null){
            count ++;
            current = current.getLink();//move along list
        }
        return count;
    }
    /**
     * append(Object) adds object to end of list
     * @param object to append
     */
    public void append(Object next){
        Node current = head;
        if(current ==  null)
            head = new Node(next, null);
        else{
            
            while(current.getLink() != null){
                current = current.getLink();
            }
            current.setLink(new Node(next, null));
        }
    }
    /**
     * delete(int index) is the same as remove, just does not return anything
     */
    public void delete(int index)throws LinkedListException{
        if(head == null)
            throw new LinkedListException("Cannot delete from an empty list");
        else if(head.getLink() == null){
            head = null;
        }
       else{
           int count = 0; //keeps track of index
           Node current = head;
           while(count < index-1){
               current = current.getLink();
           }
           if(current.getLink().getLink()!= null)
               current.setLink(current.getLink().getLink());//sets previous index link to index after target
           else{
               current.setLink(null);
           }
       }
    }
    /**
     * @return null status of head
     * null head ==> empty list
     */
    public boolean isEmpty(){
        return(head == null);
    }
    /**
     * int indexOf(Object) returns index of provided object, -1 if not found
     * @param object to look for in list
     * @return index if found, -1 if not found
     */
    public int indexOf(Object o){
        int count = 0;//current index in list
        Node current = head;
        while(current != null){
            
            if (current.getData() == o)
                return count;
                count ++;
                current = current.getLink();
        }
        //if we get here not in list
        return -1;
    }
    /**
     * String toString() overrides Java's built-in toString() method
     * @return data in list in FIFO order, similar to queues
     */
    @Override
    public String toString(){
        String retVal = "";//starts with empty string
        Node current = head;//start at head
        if (current == null)//empty head ==> empty list
            retVal = "Empty";
        while(current != null){
            retVal += String.valueOf(current.getData()) + ", ";//append to retVal with proper foramt
            current = current.getLink();//move along list
        }
        return retVal;
    }
    /**
     * Object objectAt(int index) is essentially the reverse of int indexOf(Object), where we return the data at a specific inded
     * @param index
     * @return data stored by node at index
     * 
     */
    public Object objectAt(int index){
        int counter = 0;//position in list        
        Node current = head;
        while(counter < index){
             current = current.getLink();//move along list
             counter ++;//increment as we move
        }
        return current.getData();
    }
    /**
     * Driver for List.java and Node.java
     * NOTE: objectAt(int index) is not tested as it is tested by Stack.java's main method as
     * it is used in it's toString method
     * 
     * no param
     * no return
     */
    public static void main (String [] args){
        List empty = new List();
        List one = new List();
        List multiple = new List();
    	
        one.append(5);
        multiple.append(10);
        multiple.append(20);
        multiple.append(30);
    
        System.out.println("Empty:"+empty);
        System.out.println("One:"+one);
        System.out.println("Multiple:"+ multiple);	
        try{
            one.delete(0);
            multiple.delete(1);
        }
        catch(LinkedListException e){
            System.out.println(e.getMessage());
        }    
        System.out.println("One (upon delete):"+one);
        System.out.println("Multiple (upon delete):"+ multiple);
        
        multiple.insert(400, 2);
        System.out.println("Multiple(on insert):"+ multiple);
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
