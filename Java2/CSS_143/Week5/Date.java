
/**
 * Date.java creates a Date object with the conditions of:
 *  1 <= day <= 31
 *  1 <= month <= 12
 *  2001 <= year <= 2024
 *
 * @author Will O'Keeffe
 * @version 01/28/2018
 */
public class Date
{
    private int day;
    private int month;
    private int year;
    /**
     * Constructor for objects of class Date
     * creates empty Date object
     */
    public Date()
    {
    }
    /**
     * precondions:
     *  1<= day <=31
     *  1<= month <= 12
     *  2001 <= year <= 2024
     *
     * @param month of year
     * @param day of month
     * @param year
     *
     * creates new Date object, sets values to -1 if not met
     */
    public Date(int nMonth, int nDay, int nYear){
            if(nDay > 0 && nDay <= 31 && nMonth > 0 && nMonth <= 12 && nYear > 2000
            &&nYear < 2025){
            day = nDay;
            month = nMonth;
            year = nYear;
        }
        else{
            System.out.print("Fatal error: precondition(s) not met. They are as follows:"+
            "\n0 < day <= 31\t0 < month<= 12\t2000 < year <= 2024\n");
            day = -1;
            month = -1;
            year = -1;

        }
    }
    /**
     * @param Date object to be copied
     */
    public Date(Date other){
        day = other.day;
        month = other.month;
        year = other.year;
    }
    /**
     * precondition:
     *  new day is between 1 and 31 (inclusive)
     *  does not change data if not met
     *
     * @param new day to be set to
     */
    public void setDay(int nDay){
        if(nDay >0 && nDay < 32)
            day = nDay;
        else{
            System.out.println("Fatal error: precondition not met. "+
            "Day must be between 1 and 31 (inclusive). No data was changed.");

        }
    }
    /**
     * precondition:
     *  new month is between 1 and 12 (inclusive)
     *  does not change data if not met
     *
     * @param new month to be set to
     */
    public void setMonth(int nMonth){
        if(nMonth >0 && nMonth < 13)
            month= nMonth;
        else{
            System.out.println("Fatal error: precondition not met. "+
            "Month must be between 1 and 12 (inclusive). No data was changed.");

        }
    }
    /**
     * precondition:
     *  new year is between 2001 and 2024 (inclusive)
     *  does not change data if not met
     *
     * @param new year to be set to
     */
    public void setYear(int nYear){
        if(nYear >2000 && nYear < 2015)
            year = nYear;
        else{
            System.out.println("Fatal error: precondition not met. "+
            "Year must be between 2001 and 2024 (inclusive). No data was changed.");

        }
    }
    /**
     * @return int value of day
     */
    public int getDay(){
        return day;
    }
    /**
     * @return int value of month
     */
    public int getMonth(){
        return month;
    }
    /**
     * @return int value of year
     */
    public int getYear(){
        return year;
    }
    /**
     * compares Object other to current instance of Date.
     *
     * @return false if other is null or not a Date object or year, month, day variables are
     * not identical. true else.
     */
    public boolean equals(Object other){
        if(other == null || !(other instanceof Date)){
            return false;
        }
        Date that = (Date) other;//allows for comparison of instance variables
        if (this.year == that.year && this.month == that.month && this.day == that.day)
            return true;
        return false;
    }
    /**
     * returns date in format dd/mm/yyyy
     * overrides Java's built-in String toString()
     */
    @Override
    public String toString(){
        if(month != -1)//if month == -1, then so does the other data, default for invalid data
            return month + "/" + day + "/" + year;
        else{
            return "Invalid data";
        }
    }
}
