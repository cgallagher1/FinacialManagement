import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Locale;

public class Report 
{
	//Prints the html file
	public static void generate(ArrayList<Account> a, Calendar date) throws IOException 
	{
		for (int i = 0; i < a.size(); i++) 
		{
			//Makes sure that the accounts have been created by the date generated or else deletes them so they wont be printed
			if(date.compareTo(a.get(i).getDateCreated()) < 0)
			{
				a.remove(i);
			}
			else
			{
				a.get(i).getLatestInfo(a.get(i).getMostCurrentDate(), date);
			}
		}
		//Sorts Accounts highest to lowest
		Collections.sort(a);
		
		//Date generated
		String reportDate = new String();
		reportDate = reportDate.concat(date.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
		reportDate = reportDate.concat(" " + date.get(Calendar.DATE));
		reportDate = reportDate.concat(" " + date.get(Calendar.YEAR));
		//Opens file to read and reads information 
		BufferedReader reader = new BufferedReader(new FileReader("html/Template.html"));
		String line = reader.readLine();
		//"text" will hold the stuff we need to read to the file
		StringBuilder text = new StringBuilder();
		//Keeps reading until file is finished 
		while (line != null)
		{
			//Insert our own date
			if (line.contains("$date"))
			{
				line = line.replace("$date", reportDate);
			}
			//fills with the information from the Equity and Savings reports
			if (line.contains("$ADDSTART"))
			{
				for (int i = 0; i < a.size(); i++) 
				{
					text.append(addBody(a.get(i)));
					text.append("<div class =\"divider\"><span></span></div>");
				}
				
				while (!line.contains("$STOPADDING")) 
				{
					line = reader.readLine();
				}
				line = reader.readLine();
			}
			text.append(line);
			line = reader.readLine();
		}
		//Closes file
		reader.close();
		//Creates new html file and we add our "text" to the file
		PrintWriter writer = new PrintWriter("html/index.html");
		writer.write(text.toString());
		writer.close();
	}
	public static String addBody(Account a)
	{
		//Acquires the information about the Savings and Equity classes and puts it in html form
		StringBuilder retval = new StringBuilder();
		retval.append("<div class=\"item\">");
		retval.append("<div class=\"title\">");
		retval.append(a.getFirstName() + " " + a.getLastName()  + "</div>");
		retval.append("<div class=\"body\">");
		retval.append(a.generateReport());
		retval.append("</div>");
		retval.append("</div>");
		return retval.toString();
		
	}
}
