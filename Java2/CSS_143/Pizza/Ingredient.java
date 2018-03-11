
/**
 * Write a description of class Ingredient here.
 *
 * @author Will O'Keeffe
 * @version 03/09/2018
 */
public class Ingredient implements Comparable
{
    //instance variables
    private String description;
    private Money cost;
    private int calories;
    //deafult no-args, not used
    private Ingredient()
    {
    }
    /**
     * Constructor for Ingredient.java
     * @param description of ingredient
     * @param cost
     * @param calorie count
     */
    public Ingredient(String description, Money cost, int calories){
        this.description = description;
        this.cost = cost;
        this.calories = calories;
    }
    /**
     * @return cost of object
     */
    public Money getCost(){
        return cost;
    }
    /**
     * Overrdies Comparabel interface's int compareTo(Object) method
     * @param object to compare
     * @return value of price comparison
     */
    @Override
    public int compareTo(Object other)
    {
        Ingredient that = (Ingredient) other;
        return cost.compareTo(that.getCost());
    }
    /**
     * Overrides java's built-in boolean equals(Object) method
     * @param object to compare
     * @return value if all propreties are identical
     */
    @Override
    public boolean equals(Object other){
        if(other == null || !(other instanceof Ingredient))
            return false;
        Ingredient that = (Ingredient) other;
        if(description != that.description || cost.getMoney() != that.cost.getMoney() ||
        calories != that.calories)
            return false;
        return true;//all equal
    }
    public int getCalories(){        
        return calories;
    }
    public void setCalories(int newCalories){
        calories = newCalories;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
}
