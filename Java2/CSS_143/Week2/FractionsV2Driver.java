
/**
 * CSS143 Assignment 1: FractionsV2Driver.
 *
 * @author Will O'Keeffe
 * @version 01/17/2018
 */
//imports necessary libraries
import java.io.*;
import java.util.*;
public class FractionsV2Driver
{
    public static void main(String[] args){
        int SIZE = 1000; 
        String fileName = "fractions.txt";
        try{
            ObjectList fractions = new ObjectList(SIZE);
            int length = buildList(fileName, fractions);
            int [] counts = countRepeats(fractions, length);
            removeRepeatsAndPrint(counts, fractions);
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input. Closing system.");
            System.exit(0);
        }
        
    }
    /**
     * @param List of fractions (type ObjectList)
     * @param name of file to be read from (type String)
     * 
     * @return count of elements in the file (type int)
     * 
     * buildList reads fraction from file and then adds it as a Fraction object to the list of fractions
     */
    public static int buildList(String file, ObjectList list){
        FileInputStream fos = null;
        Scanner in = null;
        int fractionCounter = 0;
        try{
            in = new Scanner(new FileInputStream("fractions.txt"));
            //used to form list of fractions in file
            while (in.hasNextLine()){
                String line = in.nextLine();
                String [] split = line.split("/");               
                Fraction curr = new Fraction(Integer.valueOf(split[0]),Integer.valueOf(split[1]));
                list.add(curr);
                fractionCounter ++;
            }
            in.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Could not locate file fractions.txt in current directory");
            System.exit(0);
        }       
        return fractionCounter++;
    }
    /**
     * @param list of fractions 'list' (type ObjectList)
     * @param size of array (the global variable, lenght of occupied space in ObjectList [] fractions)
     * 
     * @return integer array of counts
     * 
     * countRepeats counts the occurances of a cerian instance of a ratio, reporting the lowest value occurance.
     * prints most reduced fraction in list with number of occurances to console.
     */
    public static int [] countRepeats(ObjectList list, int size){
        int [] counts = new int [size];        
        for(int i = 0; i < size; i ++){
            Object curr = list.getElement(i);
            Fraction current = Fraction.class.cast(curr); 
            int counter = 0;
            for(int j = i; j < size; j++){ 
                Fraction newFrac = Fraction.class.cast(list.getElement(j));       
                if(newFrac.equals(current))
                    counter++;                
            }
            counts[i] = counter;
        }
        return counts;
        }
        /**
         * @param a list of integers, counts of the fraction occurances (type int [] )
         * @param list of fractinos (type ObjectList)
         */
    public static void removeRepeatsAndPrint(int [] counts, ObjectList list){
        for(int i = 0; i < counts.length; i ++){
            Object curr = list.getElement(i);
            Fraction current = Fraction.class.cast(curr);
            for(int j = i; j < counts.length; j++){ 
                Fraction newFrac = Fraction.class.cast(list.getElement(j)); 
                //if current count is greater than the next count of equal numbers
                if(newFrac.equals(current) && counts [i] > counts[j])
                //replaces lower form of fraction with count of fraction total
                    if (current.getNumerator() > newFrac.getNumerator()){
                        counts[j] = counts [i];
                        //sets to 0 for later use
                        counts [i] = 0;
                    }
                    else
                        counts[j] = 0;  
            }
        }
        for(int i = 0; i < counts.length; i ++){
            if(counts[i] != 0)
                System.out.println(list.getElement(i) + " has a count of: " + counts[i]);
        }
    }
}


