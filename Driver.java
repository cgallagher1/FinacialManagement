import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

//javac -cp "YahooFinanceAPI-3.6.0.jar;." *.java
//java -cp "YahooFinanceAPI-3.6.0.jar;." Driver
public class Driver 
{
	public static void main(String[] args) 
	{
		ArrayList<Account> allAcounts = new ArrayList<Account>();
		
		//First Savings Account
		Calendar firstAccountDate = Calendar.getInstance();
		firstAccountDate.set(2015, 3, 27);
		Savings Fmoney = new Savings(1, "Frodo", "Baggins", "Shire", firstAccountDate, (float) 1000, (float) .02);
		//Deposit date
		Calendar firstTransaction = Calendar.getInstance();
		firstTransaction.set(2015, 5, 4);
		Fmoney.deposit((float) 5, firstTransaction);
		//Withdraw date
		Calendar secondTransaction = Calendar.getInstance();
		secondTransaction.set(2016, 6, 21);
		Fmoney.withdrawl((float) 10, secondTransaction);	
		allAcounts.add(Fmoney);
		
		//Second Savings Account
		Calendar secondAccountDate = Calendar.getInstance();
		secondAccountDate.set(2014, 1, 3);
		Savings Gmoney = new Savings(2, "Gandolf", "Grey", "Middle-Earth", secondAccountDate, (float) 100000,  (float) .05);
		//Deposit Date
		Calendar thirdTransaction = Calendar.getInstance();
		thirdTransaction.set(2018, 7, 8);
		Gmoney.deposit((float) 100, thirdTransaction);
		allAcounts.add(Gmoney);
		
		//First Equity Account
		Calendar thirdAccountDate = Calendar.getInstance();
		thirdAccountDate.set(2017, 2, 20);
		Equity Astock = new Equity(1, "Aragorn", "Arathorn", "Rivendell", thirdAccountDate);
		Astock.Addstock("TSLA", 5, 5);
		Astock.Addstock("LMT", 10, 7);
		allAcounts.add(Astock);
		

		try 
		{
			//Report Date
			Calendar reportDate = Calendar.getInstance();
			reportDate.set(2017, 2, 24);
			
			Report.generate(allAcounts, reportDate);
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
