
/**
 *  Bill.java creates a bill object for user, to be printed if needed using Bill.toString()
 *
 * @author Will O'Keeffe
 * @version 01/29/2018
 */
public class Bill
{
    //declare variables
    private Money amount;
    private Date dueDate;
    private Date paidDate;
    private String origonator;
    /**
     * Constructor for objects of class Bill
     * preconditions of all objects used met
     */
    public Bill(Money money, Date due, String origin)
    {
        amount = money;
        dueDate = due;
        paidDate = null;
        origonator = origin;
    }
    /**
     * Copy constructor of class Bill
     */
    public Bill(Bill toCopy){
        amount = toCopy.amount;
        dueDate = toCopy.dueDate;
        paidDate = toCopy.paidDate;
        origonator = toCopy.origonator;
    }
    /**
     * @return Date object (dueDate)
     */
    public Date getDueDate(){
        return dueDate;
    }
    /**
     * @return string value of origonator of bill
     */
    public String getOrigonator(){
        return origonator;
    }
    /**
     * @return boolean t/f based on status of paidDate
     * null = false
     * true else
     */
    public boolean isPaid(){
        if(paidDate == null)
            return false;
        return true;
    }
    /**
     * @param date bill is paid (preconditinos met for Date object)
     *
     * sets paidDate to date bill paid
     */
    public void setPaid(Date onDay){
        paidDate = onDay;
    }
    /**
     * sets bill to unpaid by setting paidDate to null
     */
    public void setUnpaid(){
        paidDate = null;
    }
    /**
     * @param date to set due date to (preconditions already for Date object)
     *
     * sets chages due date
     */
    public void setDueDate(Date nextDate){
            dueDate = nextDate;
    }
    public void setAmmount(Money nAmount){
        int oldDollars = amount.getDollars();
        oldDollars += nAmount.getDollars();
        amount.setDollars(oldDollars);
        int oldCents = amount.getCents();
        oldCents += nAmount.getCents();
        amount.setCents(oldCents);
    }
    public Money getAmount(){
        return amount;
    }
    public void setOrigonator(String nOrigonator){
        origonator = nOrigonator;
    }
    public boolean equals(Bill toCompare){
        if(toCompare == null)
            return false;
        Bill that = toCompare;//for easier comparison
        if(this.amount == that.amount && this.paidDate == that.paidDate &&
        this.dueDate == that.dueDate && this.origonator.equals(that.origonator))
            return true;
        return false;
    }
    @Override
    public String toString(){
        if(paidDate != null){
            return "Origonator: " + origonator + "\nAmount to be Paid: "+ amount +
            "\nDue Date: " + dueDate.toString() + "\tPaid on: "+paidDate.toString() + "\n";
        }
        return "Origonator: " + origonator + "\nAmount to be Paid: "+ amount +
            "\nDue Date: " + dueDate.toString() + "\tPaid on: Not Fufilled\n";
    }
}
