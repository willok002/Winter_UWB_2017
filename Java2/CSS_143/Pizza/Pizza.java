
/**
 * Write a description of class Pizza here.
 *
 * @author Will O'Keeffe
 * @version 03/09/2018
 */
public class Pizza implements PizzaComparable
{
    private ArrayList<Ingredient> ingredients;
    private int totCals;
    private Money totCost;
    private Shape myShape;
    private Fraction remaining;

    /**
     * Constructor for objects of class Pizza
     * private, no-args const
     */
    public Pizza()
    {
        remaining = new Fraction("1/1");
        ingredients = new ArrayList();
        totCost = new Money(0);
        myShape = new Circle(5);
    }
    /**
     * compares via calories in pizza
     */
    @Override
    public int compareToByCalories(Object other){
        Pizza that = (Pizza) other;
        return (int) (totCals - that.totCals);
    }
    /**
     * compares by area of pizza
     */
    @Override
    public int compareToBySize(Object other){
        if(other == null || !(other instanceof Pizza))
            return -1;
        Pizza that = (Pizza) other;
        if (myShape.getArea() < that.myShape.getArea())
            return -1;
        else if(myShape.getArea() > that.myShape.getArea())
            return 1;
        return 0; //get here theyre equal area
    }
    /**
     * compares via price
     */
    @Override
    public int compareTo(Object other){
        Pizza that = (Pizza) other;
        return (int) ((totCost.getMoney()*100) - (that.totCost.getMoney()*100));//*100 for lossless double --> int comparison (2 decimal accuracy)
    }
    public void setRemaining(Fraction f){
        remaining = f;
    }
    public Fraction getRemaining(){
        return remaining;
    }
    public int getCalories(){
        return totCals;
    }
    public Money getCose(){
        return totCost;
    }
    public double getRemainingArea(){
        return (myShape.getArea()*remaining.getRatio()); //todo: add toNum() for fraction
    }
    public void setShape(Shape s) { 
        myShape = (Shape)s.clone();
    }
    public Shape getShape() { 
        return (Shape) myShape.clone();
    }
    public void addIngredient(Ingredient a)throws PizzaException{
        ingredients.add(a);
        totCals += a.getCalories();
        totCost.add(a.getCost().getDollars(), a.getCost().getCents());
    }
    public void eatSomePizza(Fraction amt)throws PizzaException{
        double setVal = (remaining.getRatio() - amt.getRatio());
        if(setVal  == 0){
            remaining.setRatio(setVal);
            throw new PizzaException("Pizza is now gone");
        }
        if(setVal < 0)
            throw new PizzaException("Cannot have negative pizza left");
        else{
            remaining.setRatio(setVal);
        }
    }
    @Override
    public String toString(){
        return " "; //TODO: add return here
    }
}
