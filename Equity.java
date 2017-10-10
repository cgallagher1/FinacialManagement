import java.util.ArrayList;
import java.util.Calendar;

public class Equity extends Account
{
	private float totalValue;
	private ArrayList<Stockinfo> stockPurchases;
	//Creates Equity
	public Equity(int number, String fname, String lname, String adress, Calendar theDay) 
	{
		super(number, fname, lname, adress, theDay);
		stockPurchases = new ArrayList<Stockinfo>();
	}
	//Grabs stock information and adds it to our list of stocks
	public void Addstock(String ticker, int numberOfShares, int pps) 
	{
		Stockinfo newStock = new Stockinfo(ticker, numberOfShares,pps);
		stockPurchases.add(newStock);
	}
	
	//Takes pps and number of shares owned of that stock and multiplies them together to get the value of that stock 
	//then does that for all stocks in the list and that is the total value of the account
	public void getLatestInfo(Calendar d1, Calendar d2)
	{
		totalValue = 0;
		if(d2.compareTo(d1)>0)
		{
			for (int i = 0; i < stockPurchases.size(); i++) 
			{
				totalValue += (stockPurchases.get(i).getNumberOfSharesOwned() * stockPurchases.get(i).getPps());
			}
		}
	}
	//Returns total value of account
	@Override
	public float getValue()
	{
		return totalValue;
	}

	
	//Creates report that has all the information about the equity account
	@Override
	public String generateReport()
	{
		String retval = new String("<p>" + "Account Number: " + getAccountNumber() + "</p>");
		retval = retval.concat("<p>" + "Name: " + getFirstName() + " ");
		retval = retval.concat(getLastName() + "</p>");
		retval = retval.concat("<p>" + "Primary Maling Address: " + getMailingAdress()+ "</p>");
		retval = retval.concat("<p>" + "Total Value: " + totalValue + "</p>");
		for (int i = 0; i < stockPurchases.size(); i++) 
		{
			retval = retval.concat("<p>" + "**************" + "</p>");
			retval = retval.concat("<p>" + stockPurchases.get(i).getStockName() + " " +stockPurchases.get(i).getTickerSymbol()+"</p>");
			retval = retval.concat("<p>" + "Old Purchase Price: " + stockPurchases.get(i).getFakePps() + "</p>");
			retval = retval.concat("<p>" + "New Purchase Price: " + stockPurchases.get(i).getPps());
			retval = retval.concat("<p>" + "Number of Shares owned: " + stockPurchases.get(i).getNumberOfSharesOwned());
		}
		return retval;
	}
	
}
