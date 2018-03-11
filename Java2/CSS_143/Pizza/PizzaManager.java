
/**
 * Write a description of class PizzaManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class PizzaManager
{
    
    private ArrayList<Pizza> pies;

    /**
     * Constructor for objects of class PizzaManager
     */
    public PizzaManager()
    {
        pies.add(new Pizza());
        
    }
    public void eatSomePizza(Scanner keys){
        keys = new Scanner(System.in);
        System.out.println("How much pizza do you want to eat? Enter a fraction in the form: a/b");
        Fraction toEat = new Fraction(keys.next());
        Pizza current = (Pizza) pies.get(0);
        try{
            current.eatSomePizza(toEat);
        }
        catch(PizzaException e){
            System.out.println(e.getMessage());
        }
    }
    //uses selection sort
    public void sortByCalories(){
        
    }
    //uses insertion sort
    public void sortByPrice(){
        
    }
    public void sortBySize(){
        
    }
}
