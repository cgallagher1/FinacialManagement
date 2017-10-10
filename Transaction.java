
import java.util.Calendar;
import java.util.Locale;


public abstract class Transaction
{
	private Calendar date;
	private Float amount;
	private float newBal;
	private float oldBal;
	
	//Returns what type of transaction occured
	public abstract String getType();
	
	//Creates Transaction
	public Transaction(Calendar date, Float a, Float old) 
	{
		this.date = date;
		setAmount(a);
		setOldBal(old);
	}
	
	//Getters and Setters
	public Calendar getDate() 
	{
		return date;
	}
	public void setDate(Calendar date) 
	{
		this.date = date;
	}
	public Float getAmount() 
	{
		return amount;
	}
	public void setAmount(Float a) 
	{
		this.amount = a;
	}

	public float getNewBal() {
		return newBal;
	}

	public void setNewBal(float newBal) {
		this.newBal = newBal;
	}
	
	public float getOldBal() {
		return oldBal;
	}

	public void setOldBal(float oldBal) {
		this.oldBal = oldBal;
	}
	
	//Returns all the information about the Equity acount
	public String Print()
	{
		String retval = new String("<p>" + getType().concat(" on: "));
		retval = retval.concat(getDate().getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
		retval = retval.concat(" " + getDate().get(Calendar.DATE));
		retval = retval.concat(" " + getDate().get(Calendar.YEAR)+ "</p>");
		retval = retval.concat("<p>" + "Amount: "+ getAmount() + "</p>");
		retval = retval.concat("<p>" + "Old Balance " + getOldBal() + "</p>");
		retval = retval.concat("<p>" + "New Balance " + getNewBal() + "</p>");
		return retval;
	}

}
