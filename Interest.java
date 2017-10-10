import java.util.Calendar;

public class Interest extends Transaction
{
	//Creates Interest 
	public Interest(Calendar date, Float a, Float old) 
	{
		super(date, a, old);
		
	}
	
	//Returns what kind of transaction
	@Override
	public String getType()
	{
		return "Interest";
	}

}
