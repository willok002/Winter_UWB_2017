/**
 Simple driver to test Money, Date, and Bill classes
 @author Rob Nash, borrowed from cfolsen
 @author changes by Will O'Keeffe
 */
public class BillMoneyDateDriver
{

    /**
     main driver function
     pre:  none
     post: exercises the methods in Bill, Money, and Date (not done)
     */
    public static void main(String[] args)
    {
        //Construct some money
        System.out.println("Testing Money.java (no errors):");
        System.out.println();
        Money money1 = new Money(10);
        Money money2 = new Money(money1);
        //System.out.println("Money2: "+ money2.toString());
        Money m3 = new Money (30, 1);
        System.out.println();
        System.out.println("equals(Object) method");
        System.out.println("Money 3 vs Money 1: " + m3.equals(money1));
        System.out.println("Money 1 vs Money 2: " + money1.equals(money2));
        System.out.println();
        System.out.println("add(___ ___) method");
        System.out.println("Money 2 before: " + money2.toString());
        money2.add(5,10);
        System.out.println("Money 2 after: " + money2.toString());
        System.out.println();
        System.out.println("set___() method");
        System.out.println("Money 1 before:" + money1.toString());
        money1.setCents(14);
        money1.setDollars(400);
        System.out.println("Money 1 after:" + money1.toString());
        System.out.println("Before: Money1: " + money1.toString());
        money1.setMoney(30,50);
        System.out.println("After: Money1: " + money1.toString());
        System.out.println();
        System.out.println("get___() methods");
        System.out.println("Money 1 getCents():" + money1.getCents());
        System.out.println("Money 1 getDollars:" + money1.getDollars());
        System.out.println("Money 1 getMoney():" + money1.getMoney());
        System.out.println();
        System.out.println("Money objects output:");
        System.out.println(money1);
        System.out.println(money2);
        System.out.println(m3);

        System.out.println();
        System.out.println();
        System.out.println();

        //Construct some bills
        Money amount = new Money(20);
        Date dueDate = new Date(4, 30, 2007);
        Bill bill1 = new Bill(amount, dueDate, "The phone company");
        Bill bill2 = new Bill(bill1);
        Bill b3 = new Bill(amount, dueDate, "Bob");

        System.out.println("Testing  Bill.java and Date.java (no errors):");
        System.out.println();
        System.out.println("equals(object) method");
        System.out.println("bill1 vs dueDate: " + bill1.equals(dueDate));
        System.out.println("bill1 vs bill2: " + bill1.equals(bill2));
        System.out.println("bill1 vs b3: " + bill1.equals(b3));
        System.out.println();
        System.out.println("__Paid() mehods");
        System.out.println("before:  " + bill2.isPaid());
        bill2.setPaid(new Date(6, 30, 2012));
        System.out.println("intermediate:  " + bill2.isPaid());
        bill2.setUnpaid();
        System.out.println("After:  " + bill2.isPaid());
        System.out.println("Setting date to paid on 6/30/2012");
        bill2.setPaid(new Date(6, 30, 2012));
        System.out.println();
        System.out.println("set___(data) and get__() Methods");
        System.out.println("before:  " + bill2.getDueDate());
        bill2.setDueDate(new Date(5, 30, 2007));
        System.out.println("after:  " + bill2.getDueDate());
        System.out.println("before: " + bill2.getAmount());
        amount.setMoney(31, 99);
        bill2.setAmmount(amount);
        System.out.println("after: " + bill2.getAmount());
        System.out.println("before: " + bill2.getOrigonator());
        bill2.setOrigonator("Harold");
        System.out.println("after: " + bill2.getOrigonator());
        Bill bill3 = new Bill(amount, dueDate, "The record company");
        System.out.println();
        System.out.println("Bill objects output:");
        System.out.println(bill1);
        System.out.println(bill2);
        System.out.println(bill3);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Testing Money.java and Date.java (errors):");

        System.out.println();
        System.out.println("Creating money object with -1 entry" );
        Money money4 = new Money(-1);
        System.out.println();
        System.out.println("add(___ ___) method");
        System.out.println("Money 2 before: " + money2.toString());
        money2.add(-1000);
        System.out.println("Money 2 after: " + money2.toString());
        System.out.println();
        System.out.println("set___() method");
        System.out.println("Money 1 before:" + money1.toString());
        money1.setCents(5);
        money1.setDollars(-1);
        System.out.println("Money 1 after:" + money1.toString());
        System.out.println("Before: Money1: " + money1.toString());
        money1.setMoney(-3,50);
        System.out.println("After: Money1: " + money1.toString());
        System.out.println();
        System.out.println("get___() methods");
        System.out.println();
        System.out.println("Money objects output:");
        System.out.println(money1);
        System.out.println(money4);
        System.out.println(money2);
        System.out.println(m3);
        //creating invalid Date objects
        System.out.println();
        System.out.println("Creating invalid date object");
        System.out.println("Month = 30, Day = 10, Year = 2020");
        Date inv = new Date(30,10,2020);
        System.out.println("Date object output:");
        System.out.println(inv);

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("DONE");
    }
}
