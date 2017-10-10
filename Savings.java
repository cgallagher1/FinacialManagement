
import java.util.ArrayList;
import java.util.Calendar;

public class Savings extends Account 
{
	private float balance;
	private Float annuelInterestRate;
	private ArrayList<Transaction> transactions;
	
	public Savings(int number, String fname, String lname, String adress, Calendar created, Float bal, Float rate)
	{
		super(number, fname, lname, adress, created);
		setBalance(bal);
		setAnnuelInterestRate(rate);
		transactions = new ArrayList<Transaction>();
	}

	//Finds the interest occurred on January 1st of how ever many years passed and adds that occurrence as a transaction
	public void addInterest()
	{
		//Interest earned 
		float earned = balance * getAnnuelInterestRate();
		//Sets the most current date to the new year
		Calendar newYear = Calendar.getInstance();
		newYear.set(getMostCurrentDate().get(Calendar.YEAR) + 1, 0,1);
		setMostCurrentDate(newYear);
		//Creates the object interest to add to transactions
		Interest i = new Interest(newYear, earned, getBalance());
		//Sets new balance to the old balance plus interest
		setBalance(balance + earned);
		i.setNewBal(getBalance());
		transactions.add(i);
	}
	
	//Creates report that has all the information about the account
	@Override
	public String generateReport()
	{	
		//retval will be the html code needed to create the html file 
		String retval = new String("<p>" + "Account Number: " + getAccountNumber() + "</p>");
		retval = retval.concat("<p>" + "Primary Maling Address: " + getMailingAdress()+ "</p>");
		retval = retval.concat("<p>" + "Current Balance: " + getBalance() + "</p>");
		retval = retval.concat("<p>" + "Annuel Interest Rate: " + getAnnuelInterestRate()+ "</p>");
		retval = retval.concat("<h3>" +  "Transactions:" + "</h3>");
		//Adds every transaction to retval
		for (int i = 0; i < transactions.size(); i++) 
		{
			retval = retval.concat(transactions.get(i).Print());
			retval = retval.concat("<div> ****************** </div>");
		}
		return retval;

	}
	
	//Creates a deposit to add to the transactions
	public void deposit(Float amount, Calendar date)
	{
		try 
		{
			//Had to sleep because if get instance was called computer was too fast
			Thread.sleep(100);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Won't allow user to make a deposit in the past
		if (date.compareTo(getMostCurrentDate()) > 0 ) 
		{
			//Won't allow the user to deposit negative dollars
			if (amount > 0) 
			{
				//Checks to see if any years have passed to add interest and then sets the date to the most current date
				getLatestInfo(getMostCurrentDate(), date);
				setMostCurrentDate(date);
				//Creates object Deposit to add to transactions list
				Deposit d = new Deposit(date, amount, getBalance());
				//Updates balance with deposit
				setBalance(balance + amount);
				d.setNewBal(getBalance());
				transactions.add(d);
			}
			else
			{
				System.out.println("Can't deposit negative dollars");
			}
		}
		else 
		{
			System.out.println("Can't make a past deposit");
		}
		
	}
	
	//Creates a withdraw to add to the transactions
	public void withdrawl(Float amount, Calendar date)
	{
		try 
		{
			Thread.sleep(100);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		//Can't make a deposit in the past
		if (date.compareTo(getMostCurrentDate()) > 0 ) 
		{
			//Can't make a negative withdraw or take out more then you have
			if (amount > 0 && amount <= balance) 
			{
				//Checks to see if any years have passed to add interest and then sets the date to the most current date
				getLatestInfo(getMostCurrentDate(), date);
				setMostCurrentDate(date);
				//Creates Withdraw object
				Withdrawl w = new Withdrawl(date, amount, getBalance());
				//Updates balance with withdraw
				setBalance(balance - amount);
				w.setNewBal(getBalance());
				transactions.add(w);
			}
			else
			{
				System.out.println("Can't deposit negative dollars and Can't withdrawl more then your balance");
			}
		}
		else 
		{
			System.out.println("Can't make a past withdrawl");
		}
	
	}
	
	//Checks to see how many years have passed and adds interest accordingly
	public void getLatestInfo(Calendar d, Calendar newD)
	{
		if (d.get(Calendar.YEAR) < newD.get(Calendar.YEAR)) 
		{
			int numOfYearsPasted = newD.get(Calendar.YEAR) - d.get(Calendar.YEAR);
			for (int i = 0; i < numOfYearsPasted; i++) 
			{
				addInterest();
			}
					
		}
	}
	
	//Getters and Setters
	public float getBalance() 
	{
		return balance;
	}
	@Override
	public float getValue()
	{
		return getBalance();
	}
	public void setBalance(Float bal) 
	{
		this.balance = bal;
	}
	public Float getAnnuelInterestRate() 
	{
		return annuelInterestRate;
	}
	public void setAnnuelInterestRate(Float rate) 
	{
		this.annuelInterestRate = rate;
	}
	
}
