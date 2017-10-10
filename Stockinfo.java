
import java.io.IOException;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class Stockinfo
{
	private String stockName;
	private String tickerSymbol;
	private Float pps;
	private Float fakePps;
	private int numberOfSharesOwned;
	
	//Uses Yahoo stock api to get information about the stock 
	public Stockinfo(String ticker, int numToBuy, float fakePPS) 
	{
		try 
		{
			Stock stock = YahooFinance.get(ticker);
			setStockName(stock.getName());
			setTickerSymbol(ticker);
			setPps(stock.getQuote().getPrice().floatValue());
			setNumberOfSharesOwned(numToBuy);
			setFakePps(fakePPS);
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	//Getters and Setters
	public String getStockName() 
	{
		return stockName;
	}
	public void setStockName(String stockName)
	{
		this.stockName = stockName;
	}
	public String getTickerSymbol() 
	{
		return tickerSymbol;
	}
	public void setTickerSymbol(String tickerSymbol) 
	{
		this.tickerSymbol = tickerSymbol;
	}
	public float getPps() 
	{
		return pps;
	}
	public void setPps(Float pps) 
	{
		this.pps = pps;
	}
	public int getNumberOfSharesOwned() {
		return numberOfSharesOwned;
	}
	public void setNumberOfSharesOwned(int numberOfSharesOwned) {
		this.numberOfSharesOwned = numberOfSharesOwned;
	}
	public Float getFakePps() {
		return fakePps;
	}
	public void setFakePps(Float fakePps) {
		this.fakePps = fakePps;
	}


}
