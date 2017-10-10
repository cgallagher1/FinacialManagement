
import java.util.Calendar;

public class Deposit extends Transaction
{
	//Creates Deposit
	public Deposit(Calendar date,Float amount, Float bal) 
	{
		super(date, amount,bal);
	}
	
	//Returns what kind of transaction
	@Override
	public String getType()
	{
		return "Deposit";
	}
	
}
