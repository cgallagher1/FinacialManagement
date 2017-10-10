import java.util.Calendar;


public class Withdrawl extends Transaction
{
	//Creates withdraw
	public Withdrawl(Calendar date,Float amount, Float bal)  
	{
		super(date,amount, bal);
	}

	//Returns what kind of transaction
	@Override
	public String getType()
	{
		return "Withdrawl";
	}
	
}
