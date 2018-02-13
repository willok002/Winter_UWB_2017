/*
 *  Incomplete Driver for ArrayList(ObjectList), Stack and Queue
 * 
 * 
 */

public class ArrayBasedDataStructuresDriver {

    public static void main(String[] args) {
        stackTests();
        queueTests();        
        arrayListTests();
    }

    private static void arrayListTests() {
        //todo: make more tests here
        ArrayList a = new ArrayList();
        
        a.insert('B', 0);
        a.insert('a',0);
        a.insert('t',1);
        
        System.out.println(a.toString());
        
        while(a.isEmpty() == false) {
            System.out.println(a.remove(0));
        }
        
    }

    private static void queueTests() {
        //todo: make more tests here
        Queue a = new Queue();
        
        a.enqueue('B');
        a.enqueue('a');
        a.enqueue('t');
        
        System.out.println(a.toString());
        
        while(a.isEmpty() == false) {
            System.out.println(a.dequeue());
        }

    }

    private static void stackTests() {
        //todo: make more tests here
        Stack a = new Stack();
        
        a.push('B');
        a.push('a');
        a.push('t');
        
        System.out.println(a.toString());
        
        while(a.isEmpty() == false) {
            System.out.println(a.pop());
        }
    }
    

}
