import java.util.Calendar;

//Abstract class that will be the root for both savings and equity
//Comparable in order to compare the accounts and sort them highest to lowest
public abstract class Account implements Comparable<Account>
{
	
	private int AccountNumber;
	private String FirstName;
	private String LastName;
	private String MailingAdress;
	private Calendar currentDate;
	private Calendar dateCreated;
	
	//Most Current Date to set the date to the latest trasaction
	public Calendar getMostCurrentDate()
	{
		return currentDate;
	}

	public void setMostCurrentDate(Calendar currentDate) 
	{
		this.currentDate = currentDate;
	}
	
	//Sets original date the Account was created
	public Calendar getDateCreated() 
	{
		return dateCreated;
	}

	public void setDateCreated(Calendar datecreated) 
	{
		this.dateCreated = datecreated;
	}
	
	//Creates Account
	public  Account(int number, String fname, String lname, String adress, Calendar theDay)
	{
		setAccountNumber(number);
		setFirstName(fname);
		setLastName(lname);
		setMailingAdress(adress);
		setDateCreated(theDay);
		setMostCurrentDate(theDay);
		
	}
	
	//Abstract function that will generate a report that returns a string that will be loaded into the report class
	public abstract String generateReport();
	
	//Abstract function that will return the total value of an account
	public abstract float getValue();
	
	//Sets most current date to the report generated date and gets the pps
	public abstract void getLatestInfo(Calendar d1, Calendar d2);
	
	//Compares accounts and sorts them highest to lowest
	public int compareTo(Account a)
	{
		return Float.compare(a.getValue(), getValue());
	}
	
	//Getters and Setters
	public int getAccountNumber() 
	{
		return AccountNumber;
	}
	public void setAccountNumber(int accountNumber) 
	{
		AccountNumber = accountNumber;
	}

	public String getFirstName() 
	{
		return FirstName;
	}

	public void setFirstName(String firstName) 
	{
		FirstName = firstName;
	}

	public String getLastName() 
	{
		return LastName;
	}

	public void setLastName(String lastName) 
	{
		LastName = lastName;
	}

	public String getMailingAdress() 
	{
		return MailingAdress;
	}

	public void setMailingAdress(String mailingAdress) 
	{
		MailingAdress = mailingAdress;
	}
	
}
